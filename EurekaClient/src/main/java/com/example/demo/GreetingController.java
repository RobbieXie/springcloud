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

import javax.annotation.Resource;

/**
 * @author 谢天帝
 * @version v0.1 2017/6/12.
 */
@RestController
public class GreetingController {

    private final Logger logger = Logger.getLogger(getClass());

    @Resource
    private DiscoveryClient client;

    @RequestMapping(value = "/greet" , method = RequestMethod.GET)
    public String greet(@RequestParam String name){
        ServiceInstance instance = client.getLocalServiceInstance();
        logger.info("/greet, host: "+ instance.getHost()+",service_id: "+instance.getServiceId());
        return "Hi,  "+ name +" ! This is '"+instance.getServiceId()+"', my address is: '"+ instance.getHost()+":"+instance.getPort() +"'";
    }

    @RequestMapping(value = "/info" , method = RequestMethod.GET)
    public String info(){
        return "Hi, i'm compute-service!";
    }

}
