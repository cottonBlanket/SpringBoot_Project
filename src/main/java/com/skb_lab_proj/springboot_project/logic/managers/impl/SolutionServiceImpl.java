package com.skb_lab_proj.springboot_project.logic.managers.impl;

import com.skb_lab_proj.springboot_project.api.controllers.solution.dto.request.ReviewSolutionRequest;
import com.skb_lab_proj.springboot_project.api.controllers.solution.dto.request.SendSolutionRequest;
import com.skb_lab_proj.springboot_project.api.controllers.solution.dto.request.UpdateSolutionRequest;
import com.skb_lab_proj.springboot_project.api.controllers.solution.dto.response.PartSolutionResponse;
import com.skb_lab_proj.springboot_project.api.controllers.solution.dto.response.ReviewResponse;
import com.skb_lab_proj.springboot_project.api.controllers.solution.dto.response.SolutionResponse;
import com.skb_lab_proj.springboot_project.api.exception.ForbiddenException;
import com.skb_lab_proj.springboot_project.dal.solution.Solution;
import com.skb_lab_proj.springboot_project.dal.solution.enums.Status;
import com.skb_lab_proj.springboot_project.dal.solution.repositories.SolutionRepository;
import com.skb_lab_proj.springboot_project.dal.task.Task;
import com.skb_lab_proj.springboot_project.dal.task.repositories.TaskRepository;
import com.skb_lab_proj.springboot_project.dal.user.Person;
import com.skb_lab_proj.springboot_project.dal.user.repositories.PersonRepository;
import com.skb_lab_proj.springboot_project.logic.events.SolutionReviewedEvent;
import com.skb_lab_proj.springboot_project.logic.events.SolutionSentEvent;
import com.skb_lab_proj.springboot_project.logic.managers.SolutionService;
import com.skb_lab_proj.springboot_project.logic.managers.factory.SolutionFactory;
import io.micrometer.core.instrument.MeterRegistry;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@Transactional
public class SolutionServiceImpl implements SolutionService {

    SolutionRepository solutionRepository;
    TaskRepository taskRepository;
    PersonRepository personRepository;
    SolutionFactory solutionFactory;
    MeterRegistry meterRegistry;
    ApplicationEventPublisher applicationEventPublisher;
    @Override
    public PartSolutionResponse createSolution(SendSolutionRequest request, String email) {
        Task task = taskRepository.getReferenceById(request.getTaskId());
        Person student = personRepository.findPersonByEmail(email);
        Solution solution = solutionFactory.createSolutionFrom(request.getLink(), task, student);
        solution = solutionRepository.save(solution);
        meterRegistry.counter("solutions.count").increment();
        applicationEventPublisher.publishEvent(new SolutionSentEvent(student.getFullName(), solution.getLink()));
        return solutionFactory.createPartSolutionResponseFrom(solution);
    }

    @Override
    public PartSolutionResponse updateSolution(UpdateSolutionRequest request, String email) {
        Solution solution = solutionRepository.getReferenceById(request.getId());
        if(solution.getPerson().getEmail().equals(email)) {
            solution.setLink(request.getLink());
            solutionRepository.save(solution);
            return solutionFactory.createPartSolutionResponseFrom(solution);
        }
        throw new ForbiddenException("Изменение данного решения вам недоступно");
    }

    @Override
    public SolutionResponse getSolution(Long id, String email) {
        Solution solution = solutionRepository.findById(id).orElseThrow();
        Person person = personRepository.findPersonByEmail(email);
        if(solution.getPerson().getEmail().equals(email) || person.getRole().equals("ROLE_ADMIN"))
            return solutionFactory.createSolutionResponseFrom(solution);
        throw new ForbiddenException("Данное решение вам недоступно");
    }

    @Override
    public void deleteSolution(Long id, String email) {
        Solution solution = solutionRepository.findById(id).orElseThrow();
        if(solution.getPerson().getEmail().equals(email))
        {
            solutionRepository.deleteById(id);
            return;
        }
        throw new ForbiddenException("Удаление данного решения вам недоступно");
    }

    @Override
    public ReviewResponse reviewSolution(ReviewSolutionRequest request, String email) {
        Person person = personRepository.findPersonByEmail(email);
        if(person.getRole().equals("ROLE_ADMIN")) {
            Solution solution = solutionRepository.findById(request.getId()).orElseThrow();
            solution.setStatus(request.getStatus());
            solution.setScores(request.getScores());
            solutionRepository.save(solution);
            applicationEventPublisher.publishEvent(new SolutionReviewedEvent(person.getFullName(), solution.getTask().getName()));
            return solutionFactory.createReviewResponseFrom(solution);
        }
        throw new ForbiddenException("Вы должны иметь роль ADMIN, чтобы иметь доступ к проверке решений");
    }

    @Override
    public List<SolutionResponse> getAllSolutionWithFilters(Long taskId, Integer room, Status status) {
        List<Solution> solutions = solutionRepository.findAll();
        if(taskId != null)
            solutions = solutions.stream().filter(x -> x.getTask().getId().equals(taskId)).collect(Collectors.toList());
        if(status != null)
            solutions = solutions.stream().filter(x -> x.getStatus().equals(status)).collect(Collectors.toList());
        if(room != null)
            solutions = solutions.stream().filter(x -> x.getPerson().getRoom().equals(room)).collect(Collectors.toList());
        return solutions.stream().map(solutionFactory::createSolutionResponseFrom).collect(Collectors.toList());
    }
}
