package com.example.eurekaClient

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.netflix.eureka.EnableEurekaClient

@SpringBootApplication
@EnableEurekaClient
class EurekaClient8765Application

fun main(args: Array<String>) {
    runApplication<EurekaClient8765Application>(*args)
}