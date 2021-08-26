package com.example.eureka

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.netflix.eureka.EnableEurekaClient

@SpringBootApplication
@EnableEurekaClient
class EurekaClient8002Application

fun main(args: Array<String>) {
    runApplication<EurekaClient8002Application>(*args)
}