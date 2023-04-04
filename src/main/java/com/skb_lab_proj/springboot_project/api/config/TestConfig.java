package com.skb_lab_proj.springboot_project.api.config;

import com.skb_lab_proj.springboot_project.api.config.properties.TestProperties;
import com.skb_lab_proj.springboot_project.logic.entities.Lesson;
import com.skb_lab_proj.springboot_project.logic.entities.User;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@EnableConfigurationProperties(TestProperties.class)
@Configuration
public class TestConfig {
    @Bean(name = "test")
    @Profile("test")
    public User createUser(){
        return new User();
    }

    @ConditionalOnBean(name = "test")
    public Lesson createLesson(){
        return new Lesson();
    }

    /*@ConditionalOnProperty()*/
}
