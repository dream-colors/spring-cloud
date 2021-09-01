package pers.meteor.eurekaOpenFeign

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker
import org.springframework.cloud.netflix.eureka.EnableEurekaClient

@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker
class EurekaOpenFeignClient8007Application

fun main(args: Array<String>) {
    runApplication<EurekaOpenFeignClient8007Application>(*args)
}