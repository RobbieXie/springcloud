package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 谢天帝
 * @version v0.1 2017/6/12.
 */
@RestController
public class ConsumerController {

    @Autowired
    GreetingService greetingService;

    @RequestMapping(value = "/greet", method = RequestMethod.GET)
    public String add() throws Exception {
        return greetingService.greet();
    }
}
