package com.como.archi.otel.c.infrastructure.persistence.repository;

import com.como.archi.otel.c.domain.model.aggregate.Payment;
import com.como.archi.otel.c.domain.repository.PaymentRepository;
import com.como.archi.otel.c.infrastructure.persistence.converter.PaymentConverter;
import com.como.archi.otel.c.infrastructure.persistence.po.PaymentPO;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 【Infrastructure 层 - Repository Impl】支付记录仓储 Mock 实现。
 *
 * <p>使用两个 Map 分别支持按 paymentId 和 orderId 查询。
 */
@Repository
public class PaymentRepositoryImpl implements PaymentRepository {

    private final Map<String, PaymentPO> storeByPaymentId = new ConcurrentHashMap<>();
    private final Map<String, String> orderIdIndex = new ConcurrentHashMap<>();

    @Override
    public void save(Payment payment) {
        PaymentPO po = PaymentConverter.toPO(payment);
        storeByPaymentId.put(payment.getPaymentId().toString(), po);
        orderIdIndex.put(payment.getOrderId(), payment.getPaymentId().toString());
    }

    @Override
    public Optional<Payment> findByPaymentId(UUID paymentId) {
        PaymentPO po = storeByPaymentId.get(paymentId.toString());
        return Optional.ofNullable(po).map(PaymentConverter::toDomain);
    }

    @Override
    public Optional<Payment> findByOrderId(String orderId) {
        String paymentId = orderIdIndex.get(orderId);
        if (paymentId == null) return Optional.empty();
        return findByPaymentId(UUID.fromString(paymentId));
    }
}
