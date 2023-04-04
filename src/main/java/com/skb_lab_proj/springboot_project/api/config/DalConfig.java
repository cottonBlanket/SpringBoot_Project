package com.skb_lab_proj.springboot_project.api.config;

import com.skb_lab_proj.springboot_project.api.config.properties.DalProperties;
import com.skb_lab_proj.springboot_project.api.config.properties.TestProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@EnableConfigurationProperties(DalProperties.class)
@Configuration
public class DalConfig {

}
