package fr.aelion.java.springbootdemo.demo.controllers;

import fr.aelion.java.springbootdemo.demo.services.DemoService;
import fr.aelion.java.springbootdemo.demo.services.DemoServiceBis;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/api/v1/demo/hello")
@Log4j2
public class DemoController {

    private final DemoService demoService;

    private final DemoServiceBis demoServiceBis;


    @Autowired
    public DemoController(DemoService demoService, DemoServiceBis demoServiceBis) {
        log.debug("DemoController new instance");
        this.demoService = demoService;
        this.demoServiceBis = demoServiceBis;
    }

    @RequestMapping("service1")
    @ResponseBody //
    public String service1() {
        return "Hello !!! " + this.demoService.doSomething();
    }

    @RequestMapping("service2")
    @ResponseBody //
    public String service2() {
        return "Hello !!! " + this.demoServiceBis.doSomething();
    }
}
