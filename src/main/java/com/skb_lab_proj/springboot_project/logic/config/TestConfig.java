package com.skb_lab_proj.springboot_project.logic.config;

import com.skb_lab_proj.springboot_project.dal.lesson.Lesson;
import com.skb_lab_proj.springboot_project.dal.task.Task;
import com.skb_lab_proj.springboot_project.dal.user.User;
import com.skb_lab_proj.springboot_project.logic.config.properties.TestProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@EnableConfigurationProperties(TestProperties.class)
@SpringBootApplication
public class TestConfig {
    public static void main(String[] args) {
        SpringApplication.run(TestConfig.class, args);
    }
    @Bean(name = "test")
    @Profile("test")
    public User CreateUser(){
        return new User();
    }

    @ConditionalOnBean(name = "test")
    public Lesson CreateLesson(){
        return new Lesson();
    }

    @ConditionalOnProperty
            (prefix = "test", name = "application", havingValue = "defult")
    public Task CreateTask(){
        return new Task();
    }
}
