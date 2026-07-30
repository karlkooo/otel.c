package com.como.archi.otel.c.application.command;

import java.math.BigDecimal;

/**
 * 【Application 层 - Command】处理支付命令。
 *
 * <p>由 System B 发起调用，经 interfaces 层 Assembler 转换而来。
 */
public class ProcessPaymentCommand {

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
