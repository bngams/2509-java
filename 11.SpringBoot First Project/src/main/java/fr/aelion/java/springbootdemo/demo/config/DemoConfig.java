package fr.aelion.java.springbootdemo.demo.config;

import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@Scope("prototype")
@Log4j2
public class DemoConfig {

    public DemoConfig() {
        log.debug("DemoConfig new instance");
    }

    public String getConfig() {
        return "Some env. vars or config...";
    }

}
