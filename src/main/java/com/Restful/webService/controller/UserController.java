package com.Restful.webService.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @RequestMapping(value = "/hello-world",method = RequestMethod.GET)
    @ResponseBody
    public String helloWorld(){
        return "Hello World";
    }

}
