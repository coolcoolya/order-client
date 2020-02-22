package com.example.orderclient;

import com.example.orderclient.rule.MyRuler;
import com.netflix.loadbalancer.IRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.web.client.RestTemplate;

@EnableFeignClients//开起Feign
@EnableEurekaClient
@SpringBootApplication
public class OrderClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderClientApplication.class, args);
    }

    @Bean//将实例new RestTemplate()通过@Bean注解方式，注入到Springboot容器中，调用的时候通过注解@Autowired根据名称找到这个Bean对象。
    @LoadBalanced//1 使restTemplate在请求时拥有客户端负载均衡能力（开起本地负载均衡） 2 有了这个注解，在调用的时候才能通过别名访问到member服务，否则会报错UnknownHostException: app-member
    RestTemplate restTemplate(){
        return new RestTemplate();
    }

//    @Bean
//    @Primary   //自定义轮训规则，实现IRule接口，并注入到容器中，就会按自定义的规则实现负载均衡
    public IRule getIRule(){
        return new MyRuler();
    }

}
