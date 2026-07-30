package com.como.archi.otel.c.domain.service;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * 【Domain 层 - 领域服务】支付业务规则校验。
 *
 * <p>校验支付请求的合法性：
 * <ul>
 *   <li>orderId 不能为空</li>
 *   <li>userId 不能为空</li>
 *   <li>支付金额必须大于 0</li>
 * </ul>
 */
@Service
public class PaymentDomainService {

    public void validate(String orderId, String userId, BigDecimal amount) {
        if (orderId == null || orderId.isBlank()) {
            throw new IllegalArgumentException("orderId cannot be empty");
        }
        if (userId == null || userId.isBlank()) {
            throw new IllegalArgumentException("userId cannot be empty");
        }
        if (amount == null || amount.signum() <= 0) {
            throw new IllegalArgumentException("amount must be positive");
        }
    }
}
