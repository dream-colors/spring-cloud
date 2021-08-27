package pers.meteor.eurekaRibbon

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.netflix.eureka.EnableEurekaClient

@SpringBootApplication
@EnableEurekaClient
class EurekaRibbonClient8002Application

fun main(args: Array<String>) {
    runApplication<EurekaRibbonClient8002Application>(*args)
}