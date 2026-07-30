package com.como.archi.otel.c.domain.model.aggregate;

import com.como.archi.otel.c.domain.model.valueobject.PaymentStatus;

import java.math.BigDecimal;
import java.util.UUID;

/**
 * 【Domain 层 - 聚合根】支付记录。
 *
 * <p>System C 的核心聚合根，管理一笔支付从发起到完成的生命周期。
 * transactionId 由本系统生成，作为支付流水号返回给 System B。
 *
 * <p>状态流转：
 * <pre>
 *   PENDING → SUCCESS（Mock 支付成功）
 *   PENDING → FAILED （异常情况）
 * </pre>
 */
public class Payment {

    private UUID paymentId;
    private String orderId;
    private String userId;
    private BigDecimal amount;
    private String method;
    private String transactionId;
    private PaymentStatus status;

    private Payment() {}

    /**
     * 发起支付，初始状态为 PENDING，同时生成 transactionId。
     */
    public static Payment create(String orderId, String userId,
                                 BigDecimal amount, String method) {
        Payment payment = new Payment();
        payment.paymentId = UUID.randomUUID();
        payment.orderId = orderId;
        payment.userId = userId;
        payment.amount = amount;
        payment.method = method;
        payment.transactionId = "TXN-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
        payment.status = PaymentStatus.PENDING;
        return payment;
    }

    /**
     * 从持久化数据重建聚合根（仓储专用）。
     */
    public static Payment reconstitute(UUID paymentId, String orderId, String userId,
                                       BigDecimal amount, String method,
                                       String transactionId, PaymentStatus status) {
        Payment payment = new Payment();
        payment.paymentId = paymentId;
        payment.orderId = orderId;
        payment.userId = userId;
        payment.amount = amount;
        payment.method = method;
        payment.transactionId = transactionId;
        payment.status = status;
        return payment;
    }

    /** 支付成功，流转至 SUCCESS。 */
    public void succeed() {
        this.status = PaymentStatus.SUCCESS;
    }

    /** 支付失败，流转至 FAILED。 */
    public void fail() {
        this.status = PaymentStatus.FAILED;
    }

    public UUID getPaymentId() { return paymentId; }
    public String getOrderId() { return orderId; }
    public String getUserId() { return userId; }
    public BigDecimal getAmount() { return amount; }
    public String getMethod() { return method; }
    public String getTransactionId() { return transactionId; }
    public PaymentStatus getStatus() { return status; }
}
