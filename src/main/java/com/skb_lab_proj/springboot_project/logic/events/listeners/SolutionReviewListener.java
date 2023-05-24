package com.skb_lab_proj.springboot_project.logic.events.listeners;

import com.skb_lab_proj.springboot_project.logic.events.SolutionReviewedEvent;
import com.skb_lab_proj.springboot_project.logic.managers.RabbitService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
@Slf4j
public class SolutionReviewListener {
    RabbitService rabbitService;

    @EventListener
    public void usualListener(SolutionReviewedEvent event)
    {
        log.info("{}'s solution for task {} was reviewed", event.getStudentName(), event.getTask());
//        rabbitService.send(event, "solution.review");
    }
}
