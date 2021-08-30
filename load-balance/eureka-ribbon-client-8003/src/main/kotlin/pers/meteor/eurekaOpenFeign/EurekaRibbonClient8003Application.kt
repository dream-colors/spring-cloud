package pers.meteor.eurekaOpenFeign

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient

@SpringBootApplication
//@EnableEurekaClient
// 该注解用于向使用consul或者zookeeper作为注册中心时注册服务
@EnableDiscoveryClient
class EurekaRibbonClient8003Application

fun main(args: Array<String>) {
    runApplication<EurekaRibbonClient8003Application>(*args)
}