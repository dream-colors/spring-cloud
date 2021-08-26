package com.example.zookeeper.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.client.RestTemplate
import org.springframework.web.client.getForEntity
import javax.annotation.Resource

// zookeeper注册服务名
const val REQUEST_URI = "http://zookeeper-client-8005"

@RestController
class HelloController {

    @Resource
    lateinit var restTemplate: RestTemplate

    @GetMapping("/hello")
    fun hello(): String {
        // 发送请求
        val responseEntity = restTemplate.getForEntity<String>("$REQUEST_URI/hello")
        return responseEntity.body ?: ""
    }

}

