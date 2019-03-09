package com.example.demo;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author 谢天帝
 * @version v0.1 2017/6/12.
 */
@FeignClient(value = "greeting-service", fallback = GreetingClientHystrix.class)
public interface GreetingService {

    @RequestMapping(method = RequestMethod.GET, value = "/greet")
    String greet(@RequestParam(value="name") String name);

}

