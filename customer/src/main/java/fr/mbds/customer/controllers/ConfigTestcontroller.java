package fr.mbds.customer.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RefreshScope
public class ConfigTestcontroller {

    @Value("${a}")
    private int a;
    @Value("${b}")
    private int b;
    @Value("${c}")
    private int c;

    @GetMapping("/configTest")
    public Map<String, Integer> configTest()
    {
        return Map.of("a", a, "b", b, "c", c);
    }
}
