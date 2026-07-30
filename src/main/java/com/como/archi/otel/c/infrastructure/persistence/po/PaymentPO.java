package com.como.archi.otel.c.infrastructure.persistence.po;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 【Infrastructure 层 - PO】支付记录持久化对象。
 *
 * <p>与领域模型 {@link com.como.archi.otel.c.domain.model.aggregate.Payment} 分离，
 * 当前使用 ConcurrentHashMap Mock，将来接入真实 DB 只需修改实现类。
 */
public class PaymentPO {

    private String paymentId;
    private String orderId;
    private String userId;
    private BigDecimal amount;
    private String method;
    private String transactionId;
    private String status;
    private LocalDateTime createdAt;

    public String getPaymentId() { return paymentId; }
    public void setPaymentId(String paymentId) { this.paymentId = paymentId; }
    public String getOrderId() { return orderId; }
    public void setOrderId(String orderId) { this.orderId = orderId; }
    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }
    public BigDecimal getAmount() { return amount; }
    public void setAmount(BigDecimal amount) { this.amount = amount; }
    public String getMethod() { return method; }
    public void setMethod(String method) { this.method = method; }
    public String getTransactionId() { return transactionId; }
    public void setTransactionId(String transactionId) { this.transactionId = transactionId; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}
