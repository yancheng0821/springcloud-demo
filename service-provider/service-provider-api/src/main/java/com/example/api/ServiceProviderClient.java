package com.example.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("service-provider")
public interface ServiceProviderClient {

    @GetMapping("/hello")
    String sayHello();

    @GetMapping("/greet")
    String greet(@RequestParam(name = "name") String name);
}
