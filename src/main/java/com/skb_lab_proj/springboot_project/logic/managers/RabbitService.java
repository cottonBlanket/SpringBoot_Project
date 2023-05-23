package com.skb_lab_proj.springboot_project.logic.managers;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;


@Service("rabbitService")
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@Slf4j
public class RabbitService {
    ObjectMapper objectMapper;
    RabbitTemplate rabbitTemplate;

    @SneakyThrows
    public void send(Object message, String routingKey) {
        MessageProperties messageProperties = new MessageProperties();
        messageProperties.setContentType(MessageProperties.CONTENT_TYPE_JSON);
        Message msg = new Message(objectMapper.writeValueAsBytes(message), messageProperties);
        rabbitTemplate.send(routingKey, msg);
        log.info("message {} sent!", msg);
    }
}
