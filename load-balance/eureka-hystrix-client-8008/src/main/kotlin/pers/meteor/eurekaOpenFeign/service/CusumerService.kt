package pers.meteor.eurekaOpenFeign.service

import org.springframework.beans.factory.annotation.Value
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.GetMapping

@Service
@FeignClient(value = "eureka-hystrix-provider-8007")
interface CusumerService {

    @GetMapping("/hello")
    fun getMessage(): String
}
