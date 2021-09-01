package pers.meteor.eurekahystrixclient

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.netflix.eureka.EnableEurekaClient

@SpringBootApplication
@EnableEurekaClient
class EurekaHystrixClientOrder8002Application

fun main(args: Array<String>) {
    runApplication<EurekaHystrixClientOrder8002Application>(*args)
}
