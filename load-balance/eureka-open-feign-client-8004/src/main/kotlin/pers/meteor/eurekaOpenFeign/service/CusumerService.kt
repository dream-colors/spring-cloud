package pers.meteor.eurekaOpenFeign.service

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.GetMapping
import pers.meteor.eurekaOpenFeign.config.LoadStrategy

@Service
@FeignClient(value = "eureka-open-feign-client-provider", configuration = [LoadStrategy::class])
interface CusumerService {

    @GetMapping("/hello")
    fun getMessage(): String
}