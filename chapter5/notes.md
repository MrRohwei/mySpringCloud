#笔记
1. ###熔断器(Hystrix)
  - ####简介
> Zuul的主要功能是路由转发和过滤器。路由功能是微服务的一部分，比如api/user转发到user服务。
> Zuul默认和Ribbon结合实现了负载均衡的功能

   - ####功能
   `Authentication`
   `Insights`
   `Stress Testing`
   `Canary Testing`
   `Dynamic Routing`
   `Service Migration`
   `Load Shedding`
   `Security`
   `Static Response handling`
   `Active/Active traffic management`
   
   - ####注解
   `@EnableZuulProxy 开启Zuul功能`
   
   - ####配置
   ```
   zuul:
     routes:
       api-a:
         path: /api-a/**
         serviceId: service-ribbon
       api-b:
         path: /api-b/**
         serviceId: service-feign
   ```
   请求转发，/api-a/开头的请求转发给service-ribbon服务,/api-b/开头的请求转发给service-feign服务。
   
   - ####服务过滤
   新建过滤器继承ZuulFilter并实现其中4个方法
<small>   
* fileType: 返回一个字符串代表过滤类型，在zuul中定义了四种不同生命周期的过滤器类型：
   + pre:路由之前
   + routing:路由之时
   + post:路由之后
   + error:发送错误调用
* filterOrder: 过滤的顺序
* shoudFilter: 是否需要过滤，可写逻辑判断
* run: 过滤器的具体逻辑。可以很复杂，包括查sql，nosql去判断请求有无权限访问
</small>