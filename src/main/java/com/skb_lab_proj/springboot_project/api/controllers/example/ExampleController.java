package com.skb_lab_proj.springboot_project.api.controllers.example;

import com.skb_lab_proj.springboot_project.api.annotation.ExampleApiV1;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@ExampleApiV1
public class ExampleController {

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/headers")
    public Map<String, String> getAllHeaders (@RequestHeader Map<String, String> headers) {
        return headers;
    }

}
