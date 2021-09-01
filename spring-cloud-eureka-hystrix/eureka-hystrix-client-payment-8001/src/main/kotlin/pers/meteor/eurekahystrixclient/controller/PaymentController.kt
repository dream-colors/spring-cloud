package pers.meteor.eurekahystrixclient.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import pers.meteor.eurekahystrixclient.bean.CommonResult
import pers.meteor.eurekahystrixclient.service.PaymentService
import javax.annotation.Resource

/**
 *
 * @author  meteor
 * @date    2021-08-31 23:56
 */
@RestController
class PaymentController {

    @Resource
    lateinit var paymentService: PaymentService

    @GetMapping("/pay/{orderId}")
    fun pay(@PathVariable("orderId") orderId: Int): CommonResult {

        return CommonResult(200, paymentService.pay(orderId))
    }
}
