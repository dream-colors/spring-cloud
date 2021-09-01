package pers.meteor.eurekahystrixclient.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.client.RestTemplate

/**
 *
 * @author  meteor
 * @date    2021-09-01 0:50
 */
@Configuration
class WebConfig {

    @Bean
    fun setRestTemplate(): RestTemplate {
        return RestTemplate()
    }
}