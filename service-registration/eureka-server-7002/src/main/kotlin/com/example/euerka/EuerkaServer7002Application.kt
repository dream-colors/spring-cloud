package com.example.euerka

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer

@SpringBootApplication
@EnableEurekaServer
class EuerkaServer7002Application

fun main(args: Array<String>) {
    runApplication<EuerkaServer7002Application>(*args)
}
