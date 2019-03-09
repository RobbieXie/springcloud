package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author 谢天帝
 * @version v0.1 2017/6/12.
 */
@RestController
public class ConsumerController {

    @Resource
    GreetingService greetingService;

    @RequestMapping(value = "/greet", method = RequestMethod.GET)
    public String add() {
        return greetingService.greet("Feign");
    }
}
