package com.example.eurekaClient.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.client.RestTemplate
import org.springframework.web.client.getForEntity
import javax.annotation.Resource

const val REQUEST_URI = "http://CLIENT-RESPONSE"

@RestController
class HelloController {

    @Resource
    lateinit var restTemplate: RestTemplate

    @GetMapping("/hello")
    fun hello(): String {
        val responseEntity = restTemplate.getForEntity<String>("$REQUEST_URI/hello")
        return responseEntity.body ?: ""
    }

}

