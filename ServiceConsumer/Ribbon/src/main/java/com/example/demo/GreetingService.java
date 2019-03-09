package com.example.demo;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author 谢天帝
 * @version v0.1 2017/6/12.
 */
@Service
public class GreetingService {
    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "greetFallback")
    public String greet() {
        return restTemplate.getForEntity("http://GREETING-SERVICE/greet?name=Ribbon", String.class).getBody();
    }

    public String greetFallback() {
        return "error";
    }
}
