package com.example.demo.com.example.demo.model

import org.springframework.stereotype.Component

@Component("greeting.english")
class GreetingServiceEnglishImpl: GreetingService {

    override fun sayHello(name: String): String {
        return "Hello $name"
    }
}