package com.como.archi.otel.c.domain.model.valueobject;

/**
 * 【Domain 层 - 值对象】支付状态枚举。
 *
 * <p>状态流转路径：
 * <pre>
 *   PENDING → SUCCESS（支付成功）
 *   PENDING → FAILED （支付失败）
 * </pre>
 */
public enum PaymentStatus {
    /** 支付处理中 */
    PENDING,
    /** 支付成功 */
    SUCCESS,
    /** 支付失败 */
    FAILED
}
