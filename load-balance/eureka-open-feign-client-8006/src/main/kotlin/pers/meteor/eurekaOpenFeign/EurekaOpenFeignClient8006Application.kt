package pers.meteor.eurekaOpenFeign

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.netflix.eureka.EnableEurekaClient

@SpringBootApplication
@EnableEurekaClient
class EurekaOpenFeignClient8006Application

fun main(args: Array<String>) {
    runApplication<EurekaOpenFeignClient8006Application>(*args)
}