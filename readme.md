## Microservices With Spring Boot And Spring Cloud [![Twitter](https://img.shields.io/twitter/follow/piotr_minkowski.svg?style=social&logo=twitter&label=Follow%20Me)](https://twitter.com/piotr_minkowski)

[![CircleCI](https://circleci.com/gh/piomin/course-spring-microservices.svg?style=svg)](https://circleci.com/gh/piomin/course-spring-microservices)

[![SonarCloud](https://sonarcloud.io/images/project_badges/sonarcloud-black.svg)](https://sonarcloud.io/dashboard?id=piomin_course-spring-microservices)
[![Bugs](https://sonarcloud.io/api/project_badges/measure?project=piomin_course-spring-microservices&metric=bugs)](https://sonarcloud.io/dashboard?id=piomin_course-spring-microservices)
[![Coverage](https://sonarcloud.io/api/project_badges/measure?project=piomin_course-spring-microservices&metric=coverage)](https://sonarcloud.io/dashboard?id=piomin_course-spring-microservices)
[![Lines of Code](https://sonarcloud.io/api/project_badges/measure?project=piomin_course-spring-microservices&metric=ncloc)](https://sonarcloud.io/dashboard?id=piomin_course-spring-microservices)

That is repository with examples used for video course _Microservices With Spring Boot And Spring Cloud_.

### Requirements
To run the example applications you need to have installed:
1. Intellij IDEA
2. JDK 11+
3. Maven

### Structure 
Each directory in the root project is related with the single part of the course.



[Part 1 - Introduction to Spring Boot](https://www.youtube.com/watch?v=KnbH4hOswLA)
- intro-to-spring-boot
- create docker network
``` docker network create micro ```
- show docker network
```docker network ls```
- create elastic search docker image and attach to network
```  docker run -d --name elasticsearch --net micro -p 9200:9200 -p 9300:9300 -e "discovery.type=single-node" elasticsearch:7.6.2 ```
- before running logstash configure and create the logstash file:


```

file name: // logstash.conf at home directory
input {
  http {
    port => 5000
  }
}

filter {
  json {
    source => "message"
  }
}

output {
  elasticsearch {
    hosts => ["http://elasticsearch:9200"]
    index => "spring-boot-actuator"
  }
  stdout { codec => rubydebug }
}

```
- create logstash container
```  
docker run -d --name logstash --net micro -p 5000:5000 -v ~/logstash.conf:/usr/share/logstash/pipeline/logstash.conf docker.elastic.co/logstash/logstash:7.6.2
```
- check the images created
``` docker ps```
- create kibana container
``` docker run -d --name kibana --net micro -e "ELASTICSEARCH_URL=http://elasticsearch:9200" -p 5601:5601 docker.elastic.co/kibana/kibana:7.6.2```
- run the springboot app created
``` 
docker run  -d --name intro --net micro -p 8080:8080 oludayoadeoye/intro-to-spring-boot
-e LOGSTASH_HOST=192.168.99.100 -e LOGSTASH_PORT=5000 
```
- view the logs 
``` docker logs -f intro```
- build dockrer image with cheap google plugin : 
```
$ mvn compile jib:build 
```


[Part 2 - Distributed configuration & service discovery](https://www.youtube.com/watch?v=laI2yxthk3c)
- config-and-discovery

[Part 3 - Inter-service communication](https://www.youtube.com/watch?v=EJUtU_VGpuk)
- inter-communication

[Part 4 - API Gateway](https://www.youtube.com/watch?v=XIkSWHX38Tg)
- api-gateway

[Part 5 - Event-driven microservices](https://www.youtube.com/watch?v=fwhP9k0e1BY)
- event-driven
