package fr.aelion.java.springbootdemo.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// @Controller + @ResponseBody
@RestController
// Root URL current controller
@RequestMapping("/api/v1/demo/hello-bis")
public class DemoControllerBis {

    // @RequestMapping Alias with GET HTTP
    @GetMapping("")
    public String index() {
        return "Hello from Bis";
    }
}
