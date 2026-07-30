package com.como.archi.otel.c.application.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.como.archi.otel.c.application.command.ProcessPaymentCommand;
import com.como.archi.otel.c.application.dto.assembler.PaymentAssembler;
import com.como.archi.otel.c.application.dto.response.PaymentDTO;
import com.como.archi.otel.c.domain.model.aggregate.Payment;
import com.como.archi.otel.c.domain.repository.PaymentRepository;
import com.como.archi.otel.c.domain.service.PaymentDomainService;

/**
 * 【Application 层 - Service】支付处理应用服务。
 *
 * <p>System C 是链路终点，不调用任何下游系统。编排调用顺序：
 * <ol>
 *   <li>Command → Payment 聚合根（同时生成 transactionId）</li>
 *   <li>领域校验</li>
 *   <li>持久化（PENDING 状态）</li>
 *   <li>Mock 支付处理（直接成功）</li>
 *   <li>更新状态为 SUCCESS</li>
 *   <li>再次持久化</li>
 *   <li>返回 PaymentDTO（含 transactionId）</li>
 * </ol>
 */
@Service
public class PaymentApplicationService {

    private static final Logger log = LoggerFactory.getLogger(PaymentApplicationService.class);

    private final PaymentDomainService paymentDomainService;
    private final PaymentRepository paymentRepository;

    public PaymentApplicationService(PaymentDomainService paymentDomainService,
                                     PaymentRepository paymentRepository) {
        this.paymentDomainService = paymentDomainService;
        this.paymentRepository = paymentRepository;
    }

    public PaymentDTO process(ProcessPaymentCommand command) {
        log.info("S7====Project otel.c=======================Processing payment, orderId={}, userId={}, amount={}",
                command.getOrderId(), command.getUserId(), command.getAmount());

        Payment payment = Payment.create(
                command.getOrderId(),
                command.getUserId(),
                command.getAmount(),
                command.getMethod()
        );

        log.info("S8====Project otel.c=======================Payment created, paymentId={}, transactionId={}",
                payment.getPaymentId(), payment.getTransactionId());

        paymentDomainService.validate(payment.getOrderId(), payment.getUserId(), payment.getAmount());

        paymentRepository.save(payment);

        payment.succeed();
        paymentRepository.save(payment);

        log.info("S9====Project otel.c=======================Payment succeeded, paymentId={}, transactionId={}",
                payment.getPaymentId(), payment.getTransactionId());

        return PaymentAssembler.toDTO(payment);
    }
}
