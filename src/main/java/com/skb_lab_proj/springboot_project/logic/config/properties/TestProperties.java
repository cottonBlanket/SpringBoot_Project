package com.skb_lab_proj.springboot_project.logic.config.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@ConfigurationProperties("test")
public class TestProperties {
    private String hostName;
    private List<Integer> list;
    private String application;
}
