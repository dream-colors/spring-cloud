package pers.meteor.alibabanacosdiscoveryclient

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient
import org.springframework.cloud.client.loadbalancer.LoadBalanced
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient
import org.springframework.cloud.openfeign.EnableFeignClients
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.context.annotation.Bean
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.client.RestTemplate
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.bodyToMono
import reactor.core.publisher.Mono
import javax.annotation.Resource


@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
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
        // 采用自动注入简化配置
         val serviceInstance = loadBalancerClient.choose("alibaba-nacos-discovery-server")
         val url = serviceInstance.uri.toString() + "/hello?name=" + "didi"
         val restTemplate = RestTemplate()

        val result = restTemplate.getForObject(url, String::class.java)
        log.info("Invoke : $url, return : $result")
        return "Invoke : $url, return : $result"
    }

    @Resource
    lateinit var restTemplate: RestTemplate

    /**
     * 结合RestTemplate使用
     */
    @GetMapping("/testWithRestTemplate")
    fun testWithRestTemplate(): String {
        val url = "http://alibaba-nacos-discovery-server/hello?name=didi"
        val result = restTemplate.getForObject(url, String::class.java)
        log.info("Invoke : $url, return : $result")
        return "Invoke : $url, return : $result"
    }

    @Resource
    lateinit var webClientBuilder: WebClient.Builder

    /**
     * 流式webClient调用
     */
    @GetMapping("testWithWebClient")
    fun testWithWebClient(): Mono<String> {

        return webClientBuilder.build()
            .get()
            .uri("http://alibaba-nacos-discovery-server/hello?name=didi")
            .retrieve()
            .bodyToMono()
    }

    @Resource
    lateinit var client: Client

    /**
     * 结合openFeign使用
     */
    @GetMapping("/testWithOpenFeign")
    fun testWithOpenFeign(): String {
        val result = client.hello("didi")
        return "result: $result"
    }
}

@FeignClient("alibaba-nacos-discovery-server")
interface Client {

    @GetMapping("/hello")
    fun hello(@RequestParam("name") name: String): String
}