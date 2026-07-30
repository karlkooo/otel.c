package com.como.archi.otel.c.infrastructure.persistence.converter;

import com.como.archi.otel.c.domain.model.aggregate.Payment;
import com.como.archi.otel.c.domain.model.valueobject.PaymentStatus;
import com.como.archi.otel.c.infrastructure.persistence.po.PaymentPO;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * 【Infrastructure 层 - Converter】Payment 聚合根 ↔ PaymentPO 双向转换器。
 */
public class PaymentConverter {

    public static PaymentPO toPO(Payment payment) {
        PaymentPO po = new PaymentPO();
        po.setPaymentId(payment.getPaymentId().toString());
        po.setOrderId(payment.getOrderId());
        po.setUserId(payment.getUserId());
        po.setAmount(payment.getAmount());
        po.setMethod(payment.getMethod());
        po.setTransactionId(payment.getTransactionId());
        po.setStatus(payment.getStatus().name());
        po.setCreatedAt(LocalDateTime.now());
        return po;
    }

    public static Payment toDomain(PaymentPO po) {
        return Payment.reconstitute(
                UUID.fromString(po.getPaymentId()),
                po.getOrderId(),
                po.getUserId(),
                po.getAmount(),
                po.getMethod(),
                po.getTransactionId(),
                PaymentStatus.valueOf(po.getStatus())
        );
    }
}
