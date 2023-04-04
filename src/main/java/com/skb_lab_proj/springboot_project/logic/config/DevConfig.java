package com.skb_lab_proj.springboot_project.logic.config;

import com.skb_lab_proj.springboot_project.logic.config.properties.DevProperties;
import com.skb_lab_proj.springboot_project.logic.config.properties.ProdProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties(DevProperties.class)
@SpringBootApplication
public class DevConfig {
    public static void main(String[] args) {
        SpringApplication.run(DevConfig.class, args);
    }
}
