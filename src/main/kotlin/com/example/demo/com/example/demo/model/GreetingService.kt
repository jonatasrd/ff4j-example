package com.example.demo.com.example.demo.model

import org.ff4j.aop.Flip


interface GreetingService {

    @Flip(name="language-french", alterBean="greeting.french")
    fun sayHello(name: String): String
}