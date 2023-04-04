package com.skb_lab_proj.springboot_project.logic.config.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@ConfigurationProperties("prod")
public class ProdProperties {
    private String hostName;
    private List<Integer> list;
    private String application;
}
