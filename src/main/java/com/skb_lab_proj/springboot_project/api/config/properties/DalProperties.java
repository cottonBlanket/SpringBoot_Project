package com.skb_lab_proj.springboot_project.api.config.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

@ConfigurationProperties("dal")
public class DalProperties {
    String name;

    List<Integer> listValue;
}
