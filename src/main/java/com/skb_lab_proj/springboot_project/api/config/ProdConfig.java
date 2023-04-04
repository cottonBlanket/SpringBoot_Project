package com.skb_lab_proj.springboot_project.api.config;

import com.skb_lab_proj.springboot_project.api.config.properties.ProdProperties;
import com.skb_lab_proj.springboot_project.api.config.properties.TestProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@EnableConfigurationProperties(ProdProperties.class)
@Configuration
public class ProdConfig {
}
