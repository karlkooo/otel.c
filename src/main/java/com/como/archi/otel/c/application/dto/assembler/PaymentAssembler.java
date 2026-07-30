package com.como.archi.otel.c.application.dto.assembler;

import com.como.archi.otel.c.application.dto.response.PaymentDTO;
import com.como.archi.otel.c.domain.model.aggregate.Payment;

/**
 * 【Application 层 - Assembler】Payment 聚合根 → 输出 DTO 转换器。
 */
public class PaymentAssembler {

    public static PaymentDTO toDTO(Payment payment) {
        PaymentDTO dto = new PaymentDTO();
        dto.setSuccess(true);
        dto.setPaymentId(payment.getPaymentId().toString());
        dto.setOrderId(payment.getOrderId());
        dto.setTransactionId(payment.getTransactionId());
        dto.setAmount(payment.getAmount());
        dto.setStatus(payment.getStatus().name());
        dto.setMessage("Payment processed successfully");
        return dto;
    }

    public static PaymentDTO failure(String orderId, String message) {
        PaymentDTO dto = new PaymentDTO();
        dto.setSuccess(false);
        dto.setOrderId(orderId);
        dto.setMessage(message);
        return dto;
    }
}
