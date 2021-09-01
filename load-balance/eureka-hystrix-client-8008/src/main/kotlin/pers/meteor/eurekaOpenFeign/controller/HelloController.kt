package pers.meteor.eurekaOpenFeign.controller

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty
import org.springframework.cloud.netflix.eureka.EurekaDiscoveryClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import pers.meteor.eurekaOpenFeign.service.CusumerService
import javax.annotation.Resource

@RestController
class HelloController {

    @Resource
    lateinit var discoveryClient: EurekaDiscoveryClient

    @Resource
    lateinit var cusumerService: CusumerService

    @GetMapping("/hello")
    @HystrixCommand(
        fallbackMethod = "paymentTimeOutFallbackMethod",
        commandProperties = [
        HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="1000")]
    )
    fun getMessage(): String {
        return cusumerService.getMessage()
    }

    @GetMapping("/dicovery")
    fun discovery(): Any {
        discoveryClient.getInstances("eureka-ribbon-client-provider").forEach {
            println("serviceId: ${it.serviceId}; host: ${it.host}; port: ${it.port}")
        }

        return discoveryClient
    }

    //善后方法
    fun paymentTimeOutFallbackMethod(): String{
        return "我是消费者80,对方支付系统繁忙请10秒钟后再试或者自己运行出错请检查自己,o(╥﹏╥)o";
    }
}

