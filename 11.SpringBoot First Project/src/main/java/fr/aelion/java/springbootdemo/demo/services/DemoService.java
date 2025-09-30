package fr.aelion.java.springbootdemo.demo.services;

import fr.aelion.java.springbootdemo.demo.config.DemoConfig;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class DemoService {

    private final DemoConfig config;

    @Autowired
    public DemoService(@Qualifier("demoConfig") DemoConfig config) {
        log.debug("DemoService new instance");
        this.config = config;
    }

    public String doSomething() {
        return "I have done something in Demo Service with config: " + this.config;
    }

}
