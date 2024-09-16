package com.example.serviceConsumer.controller;

import com.example.api.ServiceProviderClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestConsumer {

    @Autowired
    private ServiceProviderClient serviceProviderClient;

    @GetMapping("/testConsume")
    public String testConsume() {
        return serviceProviderClient.sayHello();
    }

    @GetMapping("/testConsumeGreet")
    public String testConsumeGreet(@RequestParam(name = "name", defaultValue = "World") String name) {
        return serviceProviderClient.greet(name);
    }
}
