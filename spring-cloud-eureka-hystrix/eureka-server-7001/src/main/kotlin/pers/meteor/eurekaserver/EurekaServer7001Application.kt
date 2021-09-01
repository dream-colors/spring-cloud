package pers.meteor.eurekaserver

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer

@SpringBootApplication
@EnableEurekaServer
class EurekaServer7001Application

fun main(args: Array<String>) {
    runApplication<EurekaServer7001Application>(*args)
}
