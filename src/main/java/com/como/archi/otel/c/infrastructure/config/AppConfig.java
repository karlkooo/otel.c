package com.como.archi.otel.c.infrastructure.config;

import org.springframework.context.annotation.Configuration;

/**
 * 【Infrastructure 层 - Config】技术组件 Bean 注册配置。
 *
 * <p>System C 是链路终点，无需 RestTemplate（不调用下游）。
 *
 * <p>阶段二（引入 OTel Agent）扩展点：
 * Agent 自动插桩 Spring MVC 入口，无需在此添加任何 OTel 配置。
 */
@Configuration
public class AppConfig {
}
