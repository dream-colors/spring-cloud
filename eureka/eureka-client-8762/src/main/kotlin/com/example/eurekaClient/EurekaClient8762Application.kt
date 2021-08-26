package com.example.eurekaClient

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.netflix.eureka.EnableEurekaClient
import org.springframework.context.annotation.Bean
import org.springframework.web.client.RestTemplate

@EnableEurekaClient
@SpringBootApplication
class EurekaClient8762Application

fun main(args: Array<String>) {
    runApplication<EurekaClient8762Application>(*args)
}
