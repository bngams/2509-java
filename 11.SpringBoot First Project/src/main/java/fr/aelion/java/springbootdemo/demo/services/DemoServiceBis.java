package fr.aelion.java.springbootdemo.demo.services;

import fr.aelion.java.springbootdemo.demo.config.DemoConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class DemoServiceBis {

    // /!\ Autowired sur attribut private => + complexe pour les TU / mocks (quoique mockito gère bien désormais)
    @Autowired()
    @Qualifier("demoConfig")
    private DemoConfig parentConfig;

    // /!\ Autowired sur attribut private
    @Autowired()
    @Qualifier("demoSubConfig") // DemoSubConfig Bean is a DemoConfig child
    private DemoConfig subConfig;

    public String doSomething() {
        return "I have done something in Demo Service Bis " + this.parentConfig + " - " + this.subConfig;
    }

}
