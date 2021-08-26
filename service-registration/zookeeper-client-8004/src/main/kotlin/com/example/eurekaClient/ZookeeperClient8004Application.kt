package com.example.eurekaClient

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient

@SpringBootApplication
// 该注解用于向使用consul或者zookeeper作为注册中心时注册服务
@EnableDiscoveryClient
class ZookeeperClient8004Application

fun main(args: Array<String>) {
    runApplication<ZookeeperClient8004Application>(*args)
}
