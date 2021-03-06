package pers.meteor.alibabanacosdiscoveryserver

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
@EnableDiscoveryClient
class AlibabaNacosDiscoveryServerApplication

fun main(args: Array<String>) {
    runApplication<AlibabaNacosDiscoveryServerApplication>(*args)
}

@RestController
class TestController {

    @Value("\${server.port}")
    private val serverPort: Int? = null

    val log: Logger = LoggerFactory.getLogger(TestController::class.java)

    @GetMapping("/hello")
    fun hello(@RequestParam("name") name: String): String {
        log.info("invoked name: $name" )
        return "hello($serverPort) $name"
    }
}
