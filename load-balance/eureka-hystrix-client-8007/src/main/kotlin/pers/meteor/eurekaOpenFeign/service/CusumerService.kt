package pers.meteor.eurekaOpenFeign.service

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.GetMapping

@Service
class CusumerService {

    @Value(value = "\${server.port}")
    private val serverPort: Int? = null

    @HystrixCommand(
        fallbackMethod = "timeOutHandler",
        commandProperties = [
            HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000")
        ]
    )
    fun getMessage(): String {
        Thread.sleep(1500L)
        return "hello welcome to my word $serverPort"
    }

    fun timeOutHandler(): String {
        return "线程池:  " + Thread.currentThread().name + "  8008系统繁忙或者运行报错，请稍后再试,id: o(╥﹏╥)o";
    }
}
