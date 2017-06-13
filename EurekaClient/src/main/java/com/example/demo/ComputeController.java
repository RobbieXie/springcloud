package com.example.demo;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 谢天帝
 * @version v0.1 2017/6/12.
 */
@RestController
public class ComputeController {

    private final Logger logger = Logger.getLogger(getClass());

    @Autowired
    private DiscoveryClient client;

    @Value("${from}")
    String gitVersion;

    @RequestMapping(value = "/add" , method = RequestMethod.GET)
    public String add(@RequestParam String name, @RequestParam int a, @RequestParam int b){
        ServiceInstance instance = client.getLocalServiceInstance();
        Integer r = a + b;
        logger.info("/add, host: "+ instance.getHost()+",service_id: "+instance.getServiceId()+",result: "+r);
        return "/add, From: "+ name +" ,host: "+ instance.getHost()+":"+instance.getPort()+",service_id: "+instance.getServiceId()+",result: "+r +" gitVersion: " +gitVersion;
    }

    @RequestMapping(value = "/info" , method = RequestMethod.GET)
    public String info(){
        return "Hi, i'm compute-service!";
    }

}
