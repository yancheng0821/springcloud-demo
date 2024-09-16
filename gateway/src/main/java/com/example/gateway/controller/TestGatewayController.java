package com.example.gateway.controller;

import com.example.api.ServiceProviderClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@RestController
public class TestGatewayController {

    @Autowired
    private ServiceProviderClient serviceProviderClient;

    // 模拟参数验证，并调用 service-provider 的 /hello 接口
    @GetMapping("/gateway/hello")
    public String callProviderService() {
        // 模拟参数验证逻辑，可以根据业务需求扩展
        // 这里没有参数需要验证，直接调用 hello 接口
        return serviceProviderClient.sayHello();
    }

    // 模拟参数验证，并调用 service-provider 的 /greet 接口
    @GetMapping("/gateway/greet")
    public String callGreetService(@RequestParam(name = "name") @NotEmpty @Size(min = 3, max = 20) String name) {
        // 模拟参数验证
        if (name == null || name.isEmpty()) {
            return "Name cannot be empty!";
        }
        if (name.length() < 3 || name.length() > 20) {
            return "Name length must be between 3 and 20 characters.";
        }

        // 参数验证通过后调用 service-provider 的 /greet 接口
        return serviceProviderClient.greet(name);
    }
}
