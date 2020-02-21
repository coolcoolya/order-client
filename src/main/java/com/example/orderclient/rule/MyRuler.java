package com.example.orderclient.rule;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.Server;

import java.util.List;

public class MyRuler extends AbstractLoadBalancerRule {

    @Override
    public void initWithNiwsConfig(IClientConfig iClientConfig) {

    }

    @Override
    public Server choose(Object o) {
        List<Server> serverList = this.getLoadBalancer().getAllServers();
        System.out.println("始终只调用第一个");
        return serverList.get(0);
    }
}
