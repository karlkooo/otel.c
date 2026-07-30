package com.como.archi.otel.c.domain.model.event;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * 【Domain 层 - 领域事件】支付处理完成事件。
 *
 * <p>当 {@link com.como.archi.otel.c.domain.model.aggregate.Payment} 状态
 * 流转为 SUCCESS 时发布此事件。预留结构，待引入 MQ 时激活。
 */
public class PaymentProcessedEvent {

    private final UUID paymentId;
    private final String orderId;
    private final String transactionId;
    private final BigDecimal amount;
    private final LocalDateTime occurredAt;

    public PaymentProcessedEvent(UUID paymentId, String orderId,
                                 String transactionId, BigDecimal amount) {
        this.paymentId = paymentId;
        this.orderId = orderId;
        this.transactionId = transactionId;
        this.amount = amount;
        this.occurredAt = LocalDateTime.now();
    }

    public UUID getPaymentId() { return paymentId; }
    public String getOrderId() { return orderId; }
    public String getTransactionId() { return transactionId; }
    public BigDecimal getAmount() { return amount; }
    public LocalDateTime getOccurredAt() { return occurredAt; }
}
