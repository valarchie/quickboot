## quickboot
搭建基于springboot的快速开发框架

### 完成事项

#### Web层

- [x] 封装前台加解密Filter
- [x] 定义加解密策略
- [x] 返回结果加密
- [x] 配置全局跨域
- [x] 统一参数校验以及自定义字段名称错误提示 
- [x] 统一结果、统一异常处理、统一日志
- [ ] 分布式session+redis
- [x] 上传文件的优化
  

#### 业务层


- [x] ServiceUtil全局访问点
- [x] 配置异步调用Service
- [ ] 邮件、OSS、支付
- [ ] 授权，jwt，Oauth 2.0
- [x] ThreadLocal工具类
- [x] Caffeine缓存
- [x] AOP配置Controller层，Service层统一日志

#### 数据层

- [x] 集成Mybatis Plus
- [x] Mybatis Plus模板方法
- [ ] 多数据源配置，主从配置
- [x] druid连接池配置
- [x] redis集成
- [ ] mongo集成



#### 配置层

- [x] 配置log插件，logback配置，并做好优化
- [x] 配置文件参数加密
- [x] swagger+yapi
- [x] 定时任务处理
- [x] 配置优化tomcat
- [x] 优雅配置yml，配置映射pojo


#### 添加Alibaba代码规约插件
Setting -> plugins -> alibaba Java Code Guidelines
