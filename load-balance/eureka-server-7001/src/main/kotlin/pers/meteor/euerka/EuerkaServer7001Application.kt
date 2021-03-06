package pers.meteor.euerka

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer

@SpringBootApplication
@EnableEurekaServer
class EuerkaServer7001Application

fun main(args: Array<String>) {
    runApplication<EuerkaServer7001Application>(*args)
}
