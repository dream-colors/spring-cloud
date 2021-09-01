package pers.meteor.alibabanacosdiscoveryclient

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.client.RestTemplate
import javax.annotation.Resource


@SpringBootApplication
@EnableDiscoveryClient
class AlibabaNacosDiscoveryClientApplication

fun main(args: Array<String>) {
    runApplication<AlibabaNacosDiscoveryClientApplication>(*args)
}

@RestController
class TestController {

    val log: Logger = LoggerFactory.getLogger(TestController::class.java)

    @Resource
    lateinit var loadBalancerClient: LoadBalancerClient

    @GetMapping("/test")
    fun test(): String {
        // 通过spring cloud common中的负载均衡接口选取服务提供节点实现接口调用
        val serviceInstance = loadBalancerClient.choose("alibaba-nacos-discovery-server")
        val url = serviceInstance.uri.toString() + "/hello?name=" + "didi"
        val restTemplate = RestTemplate()
        val result = restTemplate.getForObject(url, String::class.java)
        log.info("Invoke : $url, return : $result")
        return "Invoke : $url, return : $result"
    }
}