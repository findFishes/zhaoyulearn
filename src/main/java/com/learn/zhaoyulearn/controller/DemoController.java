package com.learn.zhaoyulearn.controller;

import com.learn.zhaoyulearn.vo.HelloWorld;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/h")
public class DemoController {
    @GetMapping("/helloworld")
    @ResponseBody
    public HelloWorld hello() {
        HelloWorld helloWorld = new HelloWorld();
        helloWorld.setMessage("Hello World!");
        return helloWorld;
    }
}
