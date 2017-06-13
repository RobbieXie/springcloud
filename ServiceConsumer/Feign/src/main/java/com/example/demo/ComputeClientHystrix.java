package com.example.demo;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author 谢天帝
 * @version v0.1 2017/6/12.
 */
@Component
public class ComputeClientHystrix implements ComputeClient {
    @Override
    public String add(String name,Integer a,Integer b) {
        return "error";
    }
}
