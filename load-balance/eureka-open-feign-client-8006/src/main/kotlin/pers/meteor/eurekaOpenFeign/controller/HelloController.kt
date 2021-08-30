package pers.meteor.eurekaOpenFeign.controller

import org.springframework.beans.factory.annotation.Value
import org.springframework.cloud.netflix.eureka.EurekaDiscoveryClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import javax.annotation.Resource

@RestController
class HelloController {

    @Resource
    lateinit var discoveryClient: EurekaDiscoveryClient

    @Value("\${server.port}")
    private val serverPort: Int?= null

    @GetMapping("/hello")
    fun hello(): String {
        return "hello welcome to my word $serverPort"
    }

    @GetMapping("/dicovery")
    fun discovery(): Any {
        discoveryClient.getInstances("eureka-ribbon-client-provider").forEach {
            println("serviceId: ${it.serviceId}; host: ${it.host}; port: ${it.port}")
        }

        return discoveryClient
    }
}

