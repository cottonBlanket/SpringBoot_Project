package com.skb_lab_proj.springboot_project.logic.events.listeners;

import com.skb_lab_proj.springboot_project.logic.events.PersonCreateEvent;
import com.skb_lab_proj.springboot_project.logic.managers.RabbitService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

@Component
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
@Slf4j
public class PersonCreateListener {
    RabbitService rabbitService;

    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    @SneakyThrows
    public void handlePersonCreateEvent(PersonCreateEvent event) {
        log.info("Person with email {} was created!", event.getEmail());
//        rabbitService.send(event, "person.create");
    }
}
