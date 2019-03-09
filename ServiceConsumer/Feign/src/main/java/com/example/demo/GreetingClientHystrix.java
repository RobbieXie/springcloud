package com.example.demo;

import org.springframework.stereotype.Component;

/**
 * @author 谢天帝
 * @version v0.1 2017/6/12.
 */
@Component
public class GreetingClientHystrix implements GreetingService {
    @Override
    public String greet(String name) {
        return "error";
    }
}
