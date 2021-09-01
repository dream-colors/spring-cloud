package pers.meteor.eurekahystrixclient

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.netflix.eureka.EnableEurekaClient

@SpringBootApplication
@EnableEurekaClient
class EurekaHystrixClientPayment8001Application

fun main(args: Array<String>) {
    runApplication<EurekaHystrixClientPayment8001Application>(*args)
}
