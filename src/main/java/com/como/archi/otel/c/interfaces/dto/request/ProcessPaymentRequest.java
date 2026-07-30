package com.como.archi.otel.c.interfaces.dto.request;

import java.math.BigDecimal;

/**
 * 【Interfaces 层 - Request DTO】处理支付 HTTP 请求入参。
 *
 * <p>接收 System B {@code PaymentServiceGateway} 发来的 JSON 请求体。
 * 字段与 System B 的 {@code ProcessPaymentRequest} 报文格式对齐。
 */
public class ProcessPaymentRequest {

    private String orderId;
    private String userId;
    private BigDecimal amount;
    private String method;

    public String getOrderId() { return orderId; }
    public void setOrderId(String orderId) { this.orderId = orderId; }
    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }
    public BigDecimal getAmount() { return amount; }
    public void setAmount(BigDecimal amount) { this.amount = amount; }
    public String getMethod() { return method; }
    public void setMethod(String method) { this.method = method; }
}
