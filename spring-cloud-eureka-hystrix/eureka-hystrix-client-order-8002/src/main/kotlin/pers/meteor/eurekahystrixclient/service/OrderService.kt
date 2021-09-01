package pers.meteor.eurekahystrixclient.service

import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate
import pers.meteor.eurekahystrixclient.bean.CommonResult
import java.net.URI
import javax.annotation.Resource

/**
 *
 * @author  meteor
 * @date    2021-09-01 0:32
 */

const val PAY_URL = "http://localhost:8001/pay"

@Service
class OrderService {

    @Resource
    lateinit var restTemplate: RestTemplate

    fun order(goods: Array<String>): ResponseEntity<CommonResult> {

        goods.forEach { println(it) }

        return restTemplate.getForEntity(URI(PAY_URL + "/${goods.size}"), CommonResult::class.java)
    }
}