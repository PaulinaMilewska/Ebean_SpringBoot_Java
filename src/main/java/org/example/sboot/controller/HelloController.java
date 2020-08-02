package org.example.sboot.controller;

import io.ebean.annotation.View;
import org.example.sboot.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class HelloController {

    @Autowired
    HelloService helloService;

    public HelloController() {
    }


    //  @ResponseBody
//    @RequestMapping("/")
//  public String hello() {   return helloService.hello1(); }
    @RequestMapping("/")
    public String indexGet() {
      return "index";
    }


}



