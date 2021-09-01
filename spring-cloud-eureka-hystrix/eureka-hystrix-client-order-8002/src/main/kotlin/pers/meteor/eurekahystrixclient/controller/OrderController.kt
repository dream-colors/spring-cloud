package pers.meteor.eurekahystrixclient.controller

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import pers.meteor.eurekahystrixclient.bean.CommonResult
import pers.meteor.eurekahystrixclient.service.OrderService
import javax.annotation.Resource

/**
 *
 * @author  meteor
 * @date    2021-09-01 0:47
 */
@RestController
class OrderController {

    @Resource
    lateinit var orderService: OrderService

    @PutMapping("/order")
    fun order(@RequestParam("goods") goods: Array<String>): ResponseEntity<CommonResult> {

        return orderService.order(goods)
    }
}