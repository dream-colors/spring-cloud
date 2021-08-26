package com.example.eurekaClient.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.client.RestTemplate
import org.springframework.web.client.getForEntity
import javax.annotation.Resource

@RestController
class HelloController {

    @GetMapping("/hello")
    fun hello(): String {
        return "welcome to my word 8765"
    }


}

