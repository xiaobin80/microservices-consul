# microservices-consul

This repo contains four projects: config server, spring cloud gateway, user service and userdetails.

* config server [springcloud-config-server](https://github.com/xiaobin80/microservices-consul/tree/master/springcloud-config-server)
* gateway [springcloud-gateway-dev](https://github.com/xiaobin80/microservices-consul/tree/master/springcloud-gateway-dev)
* user service [springcloud-user-service](https://github.com/xiaobin80/microservices-consul/tree/master/springcloud-user-service)
* userdetails [springcloud-userdetails](https://github.com/xiaobin80/microservices-consul/tree/master/springcloud-userdetails)

```bash
mvn clean package -DskipTests
```

## consul-server
Consul [V1.6.2](https://releases.hashicorp.com/consul/1.6.2/consul_1.6.2_linux_amd64.zip) is deployed on WSL for development.
install see [(dev mode) install CONSUL on ubuntu](https://www.cnblogs.com/xiaobin-hlj80/p/10404368.html)

### run
```bash
consul agent -dev -bind yourIP
```

## redis-server
```bash
redis-server
```

## jaeger-server
Jaeger [V1.16](https://github.com/jaegertracing/jaeger/releases/download/v1.16.0/jaeger-1.16.0-linux-amd64.tar.gz)

### run
```bash
~/jaeger-1.16.0-linux-amd64/jaeger-all-in-one
```

open http://localhost:16686/ to access the Jaeger UI.

## config-server
* git repo [spring-cloud-config-repo](https://gitee.com/xiaobin80/spring-cloud-config-repo)

### run
```bash
java -jar config-server-0.0.3-SNAPSHOT.jar --spring.application.name=cfgserver1 --server.port=8886
java -jar config-server-0.0.3-SNAPSHOT.jar --spring.application.name=cfgserver2 --server.port=8887
```

## launch

[user list page](http://localhost:8760/user/listPage)