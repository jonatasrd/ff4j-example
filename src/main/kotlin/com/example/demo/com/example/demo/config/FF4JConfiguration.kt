package com.example.demo.com.example.demo.config

import org.ff4j.FF4j
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration
class FF4JConfiguration {
    val fF4j: FF4j

        @Bean
        get() = FF4j("ff4j-features.xml")
}