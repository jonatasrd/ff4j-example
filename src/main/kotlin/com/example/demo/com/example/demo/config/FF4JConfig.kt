package com.example.demo.com.example.demo.config

import org.ff4j.FF4j
import org.ff4j.spring.boot.web.api.config.EnableFF4jSwagger
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration
@EnableFF4jSwagger
class FF4JConfig {
    val fF4j: FF4j

        @Bean
        get() = FF4j("ff4j-features.xml")
}