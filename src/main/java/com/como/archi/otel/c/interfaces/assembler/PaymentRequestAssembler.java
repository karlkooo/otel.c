package com.como.archi.otel.c.interfaces.assembler;

import com.como.archi.otel.c.application.command.ProcessPaymentCommand;
import com.como.archi.otel.c.interfaces.dto.request.ProcessPaymentRequest;

/**
 * 【Interfaces 层 - Assembler】HTTP 请求入参 → Application Command 转换器。
 */
public class PaymentRequestAssembler {

    public static ProcessPaymentCommand toCommand(ProcessPaymentRequest request) {
        ProcessPaymentCommand command = new ProcessPaymentCommand();
        command.setOrderId(request.getOrderId());
        command.setUserId(request.getUserId());
        command.setAmount(request.getAmount());
        command.setMethod(request.getMethod());
        return command;
    }
}
