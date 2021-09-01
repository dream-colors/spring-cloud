package pers.meteor.eurekaOpenFeign.controller

import org.springframework.cloud.netflix.eureka.EurekaDiscoveryClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import pers.meteor.eurekaOpenFeign.service.CusumerService
import javax.annotation.Resource

@RestController
class HelloController {

    @Resource
    lateinit var discoveryClient: EurekaDiscoveryClient

    @Resource
    lateinit var cusumerService: CusumerService

    @GetMapping("/hello")
    fun getMessage(): String {
        return cusumerService.getMessage()
    }

    @GetMapping("/dicovery")
    fun discovery(): Any {
        discoveryClient.getInstances("eureka-ribbon-client-provider").forEach {
            println("serviceId: ${it.serviceId}; host: ${it.host}; port: ${it.port}")
        }

        return discoveryClient
    }
}

