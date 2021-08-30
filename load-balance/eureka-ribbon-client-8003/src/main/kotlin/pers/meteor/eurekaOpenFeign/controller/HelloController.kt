package pers.meteor.eurekaOpenFeign.controller

import org.springframework.beans.factory.annotation.Value
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloController {

    @Value("\${server.port}")
    private val serverPort: Int?= null

    @GetMapping("/hello")
    fun hello(): String {
        return "welcome to my word $serverPort"
    }

}

