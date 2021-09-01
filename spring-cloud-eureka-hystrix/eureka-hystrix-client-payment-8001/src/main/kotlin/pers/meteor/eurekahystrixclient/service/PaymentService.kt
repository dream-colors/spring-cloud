package pers.meteor.eurekahystrixclient.service

import org.springframework.stereotype.Service

/**
 *
 * @author  meteor
 * @date    2021-08-31 23:54
 */
@Service
class PaymentService {


    fun pay(orderId: Int): String {
        return "支付订单${orderId}成功"
    }
}