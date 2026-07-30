package com.como.archi.otel.c.application.query;

/**
 * 【Application 层 - Query】查询支付记录条件对象。预留结构。
 */
public class GetPaymentQuery {

    private final String orderId;

    public GetPaymentQuery(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderId() { return orderId; }
}
