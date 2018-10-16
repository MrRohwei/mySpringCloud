#笔记
1. ###熔断器(Hystrix)
    - ####简介
    > Netflix has created a library called Hystrix that implements the circuit breaker pattern. In a microservice architecture it is common to have multiple layers of service calls.
    > 
    > ---<small>摘自官网</small>
    >  --------------------- 
    > <small>翻译：Netflix创建了一个名为Hystrix的库，实现了断路器模式。在微服务体系结构中，通常有多个服务调用层。</small>
    
    在微服务架构中，一个请求需要调用多个服务是非常常见的，如下图：
    ![](http://upload-images.jianshu.io/upload_images/2279594-08d8d524c312c27d.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/600)
    
    较底层的服务如果出现故障，会导致连锁故障，当对特定的服务的调用的不可用达到一个阀值(Hystrix是5秒20次)，断路器会被打开
    ![](http://upload-images.jianshu.io/upload_images/2279594-8dcb1f208d62046f.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/600)
    
    断路器打开之后，可以避免连锁故障，fallback方法可以直接返回一个固定值。

2. ###注解
    ```
    @EnableHystrix 开启Hystrix
    @HystrixCommand 创建熔断器的功能，并指定fallbackMethod熔断方法
    ```
    
3. ###Feign中使用断路器
    Feign自带熔断器，但在springcloud的D版本中未打开，需要在配置文件中打开，代码如下：
    
    `feign.hystrix.enabled=true`
    
    使用时在@FeignClient注解中加"fallback=class"指定类就行了，该类需要实现注解所在类。