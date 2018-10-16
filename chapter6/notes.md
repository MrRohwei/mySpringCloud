#笔记
1. ###分布式配置中心(Spring Cloud Config)
  - ####简介
    `在分布式系统中，由于服务数量巨多，为了方便服务配置文件统一管理，实时更新，所以需要分布式配置中心组件。在Spring Cloud中，有分布式配置中心组件spring cloud config ，它支持配置服务放在配置服务的内存中（即本地），也支持放在远程Git仓库中。在spring cloud config 组件中，分两个角色，一是config server，二是config client。`
    
  - ####注解
    `@EnableConfigServer 开启配置服务器的功能`
    
  - ####配置
1. 服务端
  
    ```
        spring.application.name=config-server
        server.port=8888
        
        spring.cloud.config.server.git.uri=https://github.com/forezp/SpringcloudConfig/
        spring.cloud.config.server.git.searchPaths=respo
        spring.cloud.config.label=master
        spring.cloud.config.server.git.username=
        spring.cloud.config.server.git.password=
    ```
    - spring.cloud.config.server.git.uri：配置git仓库地址
    - spring.cloud.config.server.git.searchPaths：配置仓库路径
    - spring.cloud.config.label：配置仓库的分支
    - spring.cloud.config.server.git.username：访问git仓库的用户名
    - spring.cloud.config.server.git.password：访问git仓库的用户密码
    
2.客户端

        spring.application.name=config-client
        spring.cloud.config.label=master
        spring.cloud.config.profile=dev
        spring.cloud.config.uri= http://localhost:8888/
        server.port=8881
        
   - spring.cloud.config.label 指明远程仓库的分支
   - spring.cloud.config.profile
        - dev开发环境配置文件
        - test测试环境
        - pro正式环境
   -  spring.cloud.config.uri= http://localhost:8888/ 指明配置服务中心的网址。
   
![](http://upload-images.jianshu.io/upload_images/2279594-40ecbed6d38573d9.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/600)
     
    