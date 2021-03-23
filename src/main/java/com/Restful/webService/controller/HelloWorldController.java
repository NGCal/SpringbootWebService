package com.Restful.webService.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloWorldController {

    @RequestMapping(value = "/hello-world",method = RequestMethod.GET)
    @ResponseBody
    public String helloWorld(){
        return "Hello World";
    }

}
