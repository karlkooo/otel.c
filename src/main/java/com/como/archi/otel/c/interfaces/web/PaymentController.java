package com.como.archi.otel.c.interfaces.web;

import com.como.archi.otel.c.application.dto.response.PaymentDTO;
import com.como.archi.otel.c.application.service.PaymentApplicationService;
import com.como.archi.otel.c.interfaces.assembler.PaymentRequestAssembler;
import com.como.archi.otel.c.interfaces.dto.request.ProcessPaymentRequest;
import com.como.archi.otel.c.interfaces.dto.response.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 【Interfaces 层 - Controller】支付处理 REST 接口。
 *
 * <p>对外接口：
 * <pre>
 *   POST /payments/process
 *   调用方：System B（PaymentServiceGateway）
 * </pre>
 */
@RestController
@RequestMapping("/payments")
public class PaymentController {

    private final PaymentApplicationService applicationService;

    public PaymentController(PaymentApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @PostMapping("/process")
    public ResponseEntity<ApiResponse<PaymentDTO>> process(@RequestBody ProcessPaymentRequest request) {
        PaymentDTO dto = applicationService.process(PaymentRequestAssembler.toCommand(request));
        return ResponseEntity.ok(ApiResponse.success(dto));
    }
}
