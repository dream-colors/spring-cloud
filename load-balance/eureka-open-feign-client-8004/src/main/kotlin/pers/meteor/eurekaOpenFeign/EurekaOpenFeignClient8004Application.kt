package pers.meteor.eurekaOpenFeign

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.netflix.eureka.EnableEurekaClient
import org.springframework.cloud.openfeign.EnableFeignClients

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
class EurekaOpenFeignClient8004Application

fun main(args: Array<String>) {
    runApplication<EurekaOpenFeignClient8004Application>(*args)
}