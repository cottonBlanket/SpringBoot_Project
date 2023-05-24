package com.skb_lab_proj.springboot_project.logic.events.listeners;

import com.skb_lab_proj.springboot_project.logic.config.RabbitConfig;
import com.skb_lab_proj.springboot_project.logic.events.SolutionSentEvent;
import com.skb_lab_proj.springboot_project.logic.managers.RabbitService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
@Slf4j
public class SolutionSentListenerAsync {
    RabbitService rabbitService;

    @EventListener
    @Async
    public void asyncListener(SolutionSentEvent event) {
        log.info("Student {} sent solution with link {}", event.getStudentName(), event.getSolutionLink());
//        rabbitService.send(event, "solution.sent");
    }
}
