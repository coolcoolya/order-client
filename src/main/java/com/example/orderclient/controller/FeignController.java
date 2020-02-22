package com.example.orderclient.controller;

import com.example.orderclient.feign.MemberFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeignController {

    @Autowired
    private MemberFeign memberFeign;

    @RequestMapping("/feignMember")
    public String feignMember(){
        return memberFeign.getMember();
    }


}
