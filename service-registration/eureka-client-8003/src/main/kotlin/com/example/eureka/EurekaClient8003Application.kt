package com.example.eureka

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient

@SpringBootApplication
//@EnableEurekaClient
// 该注解用于向使用consul或者zookeeper作为注册中心时注册服务
@EnableDiscoveryClient
class EurekaClient8003Application

fun main(args: Array<String>) {
    runApplication<EurekaClient8003Application>(*args)
}