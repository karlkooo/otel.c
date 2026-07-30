package com.como.archi.otel.c.application.dto.response;

import java.math.BigDecimal;

/**
 * 【Application 层 - DTO】支付处理结果输出数据传输对象。
 *
 * <p>由 {@link com.como.archi.otel.c.application.dto.assembler.PaymentAssembler} 组装，
 * 返回给 System B，其中 transactionId 是本次支付的唯一流水号。
 */
public class PaymentDTO {

    private boolean success;
    private String paymentId;
    private String orderId;
    private String transactionId;
    private BigDecimal amount;
    private String status;
    private String message;

    public boolean isSuccess() { return success; }
    public void setSuccess(boolean success) { this.success = success; }
    public String getPaymentId() { return paymentId; }
    public void setPaymentId(String paymentId) { this.paymentId = paymentId; }
    public String getOrderId() { return orderId; }
    public void setOrderId(String orderId) { this.orderId = orderId; }
    public String getTransactionId() { return transactionId; }
    public void setTransactionId(String transactionId) { this.transactionId = transactionId; }
    public BigDecimal getAmount() { return amount; }
    public void setAmount(BigDecimal amount) { this.amount = amount; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }
}
