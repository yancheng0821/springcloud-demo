package com.example.serviceProvider.controller;

import com.example.api.ServiceProviderClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestProviderController {

    @Autowired
    private ServiceProviderClient serviceProviderClient;

    private Logger logger = LoggerFactory.getLogger(TestProviderController.class);

    @GetMapping("/hello")
    public String sayHello() {
        logger.info("Provider info++++!");
        return "Hello from Service Provider!";
    }

    @GetMapping("/greet")
    public String greet(@RequestParam(name = "name", defaultValue = "World") String name) {
        logger.info("Provider name++++!");
        return "Hello, " + name + " from Service Provider!";
    }

}
