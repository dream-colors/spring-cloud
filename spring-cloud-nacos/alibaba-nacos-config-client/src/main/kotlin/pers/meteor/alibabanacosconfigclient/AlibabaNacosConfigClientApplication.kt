package pers.meteor.alibabanacosconfigclient

import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.context.config.annotation.RefreshScope
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
class AlibabaNacosConfigClientApplication

fun main(args: Array<String>) {
    runApplication<AlibabaNacosConfigClientApplication>(*args)
}

@RestController
@RefreshScope
class TestController {

    @Value("\${didispace.title}")
    private val title = ""

    @Value("\${didispace.description}")
    private val description =""

    @Value("\${didispace.color}")
    private val color =""

    @GetMapping("/hello")
    fun hello(): String {
        return "title: $title; description: $description; color: $color"
    }
}
