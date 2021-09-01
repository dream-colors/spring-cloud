package pers.meteor.eurekaOpenFeign

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.netflix.eureka.EnableEurekaClient
import org.springframework.cloud.netflix.hystrix.EnableHystrix
import org.springframework.cloud.openfeign.EnableFeignClients
import pers.meteor.eurekaOpenFeign.config.LoadStrategy

@SpringBootApplication
@EnableFeignClients(defaultConfiguration = [LoadStrategy::class])
@EnableHystrix
class EurekaOpenFeignClient8008Application

fun main(args: Array<String>) {
    runApplication<EurekaOpenFeignClient8008Application>(*args)
}