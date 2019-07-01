package com.example.demo.com.example.demo.config

import org.ff4j.web.FF4jDispatcherServlet
import org.ff4j.FF4j
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean
import org.springframework.boot.web.servlet.ServletRegistrationBean
import org.ff4j.web.embedded.ConsoleServlet
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer
import org.springframework.boot.autoconfigure.AutoConfigureAfter
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration
@ConditionalOnClass(ConsoleServlet::class, FF4jDispatcherServlet::class)
@AutoConfigureAfter(FF4JConfiguration::class)
class FF4JWebConfiguration : SpringBootServletInitializer() {

    @Bean
    fun servletRegistrationBean(ff4jConsoleServlet: ConsoleServlet): ServletRegistrationBean<*> {
        return ServletRegistrationBean(ff4jConsoleServlet, "/ff4j-console")
    }

    @Bean
    @ConditionalOnMissingBean
    fun getFF4jServlet(ff4j: FF4j): ConsoleServlet {
        val ff4jConsoleServlet = ConsoleServlet()
        ff4jConsoleServlet.ff4j = ff4j
        return ff4jConsoleServlet
    }

    @Bean
    fun ff4jDispatcherServletRegistrationBean(ff4jDispatcherServlet: FF4jDispatcherServlet): ServletRegistrationBean<*> {
        return ServletRegistrationBean(ff4jDispatcherServlet, "/ff4j-web-console/*")
    }

    @Bean
    @ConditionalOnMissingBean
    fun getFF4jDispatcherServlet(ff4j: FF4j): FF4jDispatcherServlet {
        val ff4jConsoleServlet = FF4jDispatcherServlet()
        ff4jConsoleServlet.ff4j = ff4j
        return ff4jConsoleServlet
    }
}