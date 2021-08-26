package com.example.euerkaserver

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer

@SpringBootApplication
@EnableEurekaServer
class EuerkaServer8761Application

fun main(args: Array<String>) {
    runApplication<EuerkaServer8761Application>(*args)
}
