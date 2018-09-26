package com.oatworks.controller;

import com.oatworks.Service.DemoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
public class DemoController {

    // == fields ==
    private final DemoService demoService;


    // == constructor ==
    @Autowired
    public DemoController(DemoService demoService) {
        this.demoService = demoService;
    }


    // == request methods ==
    // http://localhost:8080/todo-list/hello
    @ResponseBody
    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    // http://localhost:8080/todo-list/hello/welcome
    // http://localhost:8080/todo-list/welcome?user=Sauron
    //prefix + name + suffix
    @GetMapping("welcome")
    public String welcome(@RequestParam String user, @RequestParam int age, Model model) {

        model.addAttribute("age", age);
        model.addAttribute("hellomessage", demoService.getHelloMessage(user));

        log.info("model= {}", model);
        return "welcome";
    }

    // == model attributes ==
    @ModelAttribute("welcomeMessage")
    public String welcomeMessage() {

        log.info("welcomeMessage() called");
        return demoService.getWelcomeMessage();
    }


}
