package com.como.archi.otel.c;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * System C - 支付处理服务（Payment Service）启动类。
 *
 * <p>本系统是履约链路的终点，负责处理订单支付：
 * <pre>
 *   A（用户下单）→ B（订单创建）→ C（支付处理）
 * </pre>
 *
 * <p>核心职责：
 * <ul>
 *   <li>接收 System B 的支付请求</li>
 *   <li>Mock 支付处理（实际场景对接支付网关）</li>
 *   <li>生成支付流水号（transactionId）返回给 B</li>
 * </ul>
 *
 * <p>运行端口：8083
 */
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
