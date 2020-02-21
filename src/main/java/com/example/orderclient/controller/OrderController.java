package com.example.orderclient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * 使用rest方式调用服务
 */

@RestController
public class OrderController {

    //restTemplate 是有SpringBoot Web组件提供的 默认整合了ribbon负载均衡器
    //restTemplate方式底层采用的是httpClient技术
    @Autowired
    private RestTemplate restTemplate;

    /**
     * 在springCloud中有两种调用方式restTemplate和feign
     * @return
     */

    //order使用rpc远程调用技术 调用会员服务
    @RequestMapping("/getOrder")
    public String getOrder(){
        //有两种方式，一种是直接调用，另一种是采用服务别名方式调用，使用别名去注册中心上获取对应的服务调用地址
        //String memberUrl = "http://127.0.0.1:8000/getMember"; 这种方式不会走注册中心
        String memberUrl = "http://app-member/getMember";
        String result = restTemplate.getForObject(memberUrl,String.class);
        System.out.println("订单服务调用会员服务，result："+result);
        return result;
    }
}
