package pers.meteor.eurekaRibbon.connfig

import com.netflix.client.config.IClientConfig
import com.netflix.loadbalancer.AbstractLoadBalancerRule
import com.netflix.loadbalancer.IRule
import com.netflix.loadbalancer.Server
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.util.concurrent.atomic.AtomicInteger

@Configuration
class LoadStrategy {

    /**
     * 系统自带负载策略
     * RoundRobinRule 轮询
     * RandomRule 随机
     * RetryRule 先按照RoundRobinRule的策略获取服务，如果获取服务失败则在指定时间内会进行重
     * WeightedResponseTimeRule 对RoundRobinRule的扩展，响应速度越快的实例选择权重越大，越容易被选择
     * BestAvailableRule 会先过滤掉由于多次访问故障而处于断路器跳闸状态的服务，然后选择一个并发量最小的服务
     * AvailabilityFilteringRule 先过滤掉故障实例，再选择并发较小的实例
     * ZoneAvoidanceRule 默认规则,复合判断server所在区域的性能和server的可用性选择服务器
     */
    @Bean
    fun customPollingStrategy(): IRule {
        return DefinedRule()
    }
}

/**
 * 自定义负载均衡策略
 */
class DefinedRule : AbstractLoadBalancerRule() {

    private val visits: AtomicInteger = AtomicInteger(1)

    /**
     * 选择返回实例
     */
    override fun choose(key: Any?): Server {
        // 获取所有可到达的服务
        // chooseServer(key)：选择服务，
        // addServers(servers: List<Server>): 添加服务,
        // markServerDown(key): 停止服务,
        // getReachableServers()获取可抵达服务，
        // getAllServers()获取所有服务
        val reachableServers = loadBalancer.reachableServers
        // 获取可抵达服务数量
        val serverSize: Int = reachableServers?.size ?: 0
        // 获取当前访问次数
        val currentVisit = visits.get()
        // 计算返回的服务坐标
        val index: Int = currentVisit % serverSize
        // 增加访问次数
        visits.incrementAndGet()
        // 返回服务
        return reachableServers[index]
    }

    /**
     * 初始话配置
     */
    override fun initWithNiwsConfig(p0: IClientConfig?) {

    }

}