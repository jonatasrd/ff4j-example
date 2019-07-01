package com.example.demo.com.example.demo.model

import org.springframework.stereotype.Component

@Component("greeting.french")
class GreetingServiceFrenchImpl: GreetingService {

    override fun sayHello(name: String): String {
        return "Bonjour $name"
    }
}