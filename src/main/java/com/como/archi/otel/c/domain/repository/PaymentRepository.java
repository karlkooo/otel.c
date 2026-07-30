package com.como.archi.otel.c.domain.repository;

import com.como.archi.otel.c.domain.model.aggregate.Payment;

import java.util.Optional;
import java.util.UUID;

/**
 * 【Domain 层 - 仓储接口】支付记录持久化契约。
 *
 * <p>接口定义在 domain 层，实现在 infrastructure 层，体现依赖倒置原则。
 */
public interface PaymentRepository {

    void save(Payment payment);

    Optional<Payment> findByPaymentId(UUID paymentId);

    Optional<Payment> findByOrderId(String orderId);
}
