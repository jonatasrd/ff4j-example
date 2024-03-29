package com.example.demo.com.example.demo.rest

import com.example.demo.com.example.demo.model.GreetingService
import org.ff4j.FF4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController


@RestController
class GreetingResource {

    @Autowired
    lateinit var ff4j: FF4j

    @Autowired
    @Qualifier("greeting.english")
    lateinit var greeting: GreetingService

    @GetMapping("/api/hello")
    fun hello(): String {
        return getText()
    }

    fun getText(): String {
        return when (ff4j.check("HelloFeature")) {
            true -> "Feature Hello is avaliable"
            false -> "Feature Hello is not avaliable"
        }
    }


    @GetMapping("/greeting")
    fun getGreeting(): String{
        return greeting.sayHello("Jonatas")
    }

}