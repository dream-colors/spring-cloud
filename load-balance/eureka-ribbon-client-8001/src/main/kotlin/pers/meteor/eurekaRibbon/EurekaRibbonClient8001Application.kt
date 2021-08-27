package pers.meteor.eurekaRibbon

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.netflix.eureka.EnableEurekaClient
import org.springframework.cloud.netflix.ribbon.RibbonClient
import pers.meteor.eurekaRibbon.connfig.LoadStrategy

@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name = "eureka-ribbon-client-provider", configuration = [LoadStrategy::class])
class EurekaRibbonClient8001Application

fun main(args: Array<String>) {
    runApplication<EurekaRibbonClient8001Application>(*args)
}
