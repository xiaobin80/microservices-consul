OpenTracing Spring Jaeger Cloud Starter Upgrade Guide
---

注意：    
  opentracing-spring-jaeger-cloud-starter不支持最新版本(1)的spring-cloud-starter-openfeign。    
  spring-cloud-starter-openfeign中的LoadBalancerFeignClient被移除了。

(1) Dev
- Spring Boot: 2.4.x+
- Spring Cloud: 2020.0+


# java files
手动创建以下3个文件.

## LoadBalancerFeignClient.java
```java
package org.springframework.cloud.openfeign.ribbon;

import feign.Client;
import org.springframework.cloud.netflix.ribbon.SpringClientFactory;

public class LoadBalancerFeignClient {
    public LoadBalancerFeignClient(Client delegate, CachingSpringLoadBalancerFactory lbClientFactory, SpringClientFactory clientFactory) {
        throw new UnsupportedOperationException();
    }

    public Client getDelegate() {
        throw new UnsupportedOperationException();
    }
}
```

## SpringClientFactory.java
```java
package org.springframework.cloud.netflix.ribbon;

public class SpringClientFactory {}
```

## CachingSpringLoadBalancerFactory.java
```java
package org.springframework.cloud.openfeign.ribbon;

public class CachingSpringLoadBalancerFactory {}
```


# Ref
- [NoClassDefFoundError: org/springframework/cloud/openfeign/ribbon/LoadBalancerFeignClient when using spring-cloud-dependencies:2020.0.0](https://github.com/opentracing-contrib/java-spring-cloud/issues/312#issuecomment-914446546)
- [spring boot集成 jaeger实现链路管理](https://www.ithere.net/article/1453028895817330690)
