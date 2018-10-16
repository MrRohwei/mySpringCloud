#笔记
##1. chapter1 AND chapter2
- ####**服务与服务的通信通过http,restful。**
- ####**spring的两种调用方式**
    1. ribbon+restTemplate
    2. feign(默认集成ribbon)

- ####**ribbon是一个负载均衡客户端，可以很好控制http和tcp的一些行为**
ribbon默认实现的配置Bean
```
 IClientConfig ribbonClientConfig: DefaultClientConfigImpl
 IRule ribbonRule: ZoneAvoidanceRule
 IPing ribbonPing: NoOpPing
 ServerList ribbonServerList: ConfigurationBasedServerList
 ServerListFilter ribbonServerListFilter: ZonePreferenceServerListFilter
 ILoadBalancer ribbonLoadBalancer: ZoneAwareLoadBalancer
```
- ####**注解**
    @EnableEurekaServer\
    @EnableEurekaClient
    `如果服务采用eureka作为注册中心时使用@EnableEurekaClient，其他注册中心使用@EnableDiscoveryClient`\
    @EnableDiscoveryClient\
    @Bean\
    @LoadBalanced
    `表明这个restRemplate开启负载均衡的功能。`

####配置
eureka server在启动之后会尝试注册自身，而
`eureka.client.register-with-eureka=false`和
`eureka.client.fetch-register=false`
这两项配置是禁止这个行为。\
server.port --->服务启动的端口\
spring.application.name --->这是个服务名称，配置高可用以及其他服务访问该服务的时候，是通过这个属性找服务注册中心获取可用的访问ip的
eureka.client.serviceUrl.defaultZone --->服务注册地址
