package pers.meteor.alibabanacosdiscoveryclient.config

import org.springframework.cloud.client.loadbalancer.LoadBalanced
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.client.RestTemplate
import org.springframework.web.reactive.function.client.WebClient

@Configuration
class WebConfig {

    @Bean
    @LoadBalanced
    fun setRestTemplate(): RestTemplate {
        return RestTemplate()
    }

    @Bean
    @LoadBalanced
    fun setWebClient(): WebClient.Builder {
        return WebClient.builder()
    }
}