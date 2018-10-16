#笔记
1. ###feign简介
    feign是一个声明式的伪http客户端，使Http客户端变简单。
    使用feign只需要创建一个接口并注解，可使用feign和JAX-RS注解。
    feign支持可插拔的编码器和解码器。
    feign默认集成了ribbon，并和eureka结合，默认实现了负载均衡的效果。
    
    - feign采用的是基于接口的注解
    - feign整合了ribbon，具有负载均衡的能力
    - 整合了Hystrix，具有熔断的能力

2. ###注解
`@EnableFeignClients  开启feign功能`