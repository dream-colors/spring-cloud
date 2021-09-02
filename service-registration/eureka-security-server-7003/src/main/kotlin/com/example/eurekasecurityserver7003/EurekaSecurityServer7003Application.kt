package com.example.eurekasecurityserver7003

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.netflix.eureka.EnableEurekaClient
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer

@SpringBootApplication
@EnableEurekaServer
class EurekaSecurityServer7003Application

fun main(args: Array<String>) {
    runApplication<EurekaSecurityServer7003Application>(*args)
}
