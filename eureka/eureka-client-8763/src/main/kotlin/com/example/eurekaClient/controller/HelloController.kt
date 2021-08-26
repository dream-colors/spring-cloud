package com.example.eurekaClient.controller

import org.springframework.cloud.netflix.eureka.EurekaDiscoveryClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import javax.annotation.Resource

@RestController
class HelloController {

    @Resource
    lateinit var discoveryClient: EurekaDiscoveryClient

    @GetMapping("/hello")
    fun hello(): String {
        return "welcome to my word 8763"
    }

    @GetMapping("/dicovery")
    fun discovery(): Any {
        discoveryClient.getInstances("client-response").forEach {
            println("serviceId: ${it.serviceId}; host: ${it.host}; port: ${it.port}")
        }

        return discoveryClient
    }
}

