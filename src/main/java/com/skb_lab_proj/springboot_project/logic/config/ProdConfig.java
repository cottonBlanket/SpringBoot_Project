package com.skb_lab_proj.springboot_project.logic.config;

import com.skb_lab_proj.springboot_project.logic.config.properties.ProdProperties;
import com.skb_lab_proj.springboot_project.logic.config.properties.TestProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties(ProdProperties.class)
@SpringBootApplication
public class ProdConfig {
    public static void main(String[] args) {
        SpringApplication.run(ProdConfig.class, args);
    }
}
