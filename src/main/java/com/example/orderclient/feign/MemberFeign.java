package com.example.orderclient.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "app-member")
public interface MemberFeign {
    //Feign 书写方式，接口形式
    //@FeignClient调用服务接口，name就是服务名称。
    @RequestMapping("/getMember")
    public String getMember();
}
