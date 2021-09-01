package pers.meteor.eurekaserver.config

import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter

/**
 *
 * @author  meteor
 * @date    2021-09-01 0:59
 */
@Configuration
class WebSecurityConfig : WebSecurityConfigurerAdapter() {

    override fun configure(http: HttpSecurity?) {
        http?.csrf()?.ignoringAntMatchers("/eureka/**")
        super.configure(http)
    }


}