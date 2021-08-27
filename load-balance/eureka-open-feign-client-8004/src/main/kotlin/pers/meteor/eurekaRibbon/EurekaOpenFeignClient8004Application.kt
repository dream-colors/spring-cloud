package pers.meteor.eurekaRibbon

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.netflix.eureka.EnableEurekaClient

@SpringBootApplication
@EnableEurekaClient
class EurekaOpenFeignClient8004Application

fun main(args: Array<String>) {
    runApplication<EurekaOpenFeignClient8004Application>(*args)
}
