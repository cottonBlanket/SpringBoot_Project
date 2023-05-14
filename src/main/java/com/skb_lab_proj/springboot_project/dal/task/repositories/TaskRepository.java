package com.skb_lab_proj.springboot_project.dal.task.repositories;

import com.skb_lab_proj.springboot_project.dal.task.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
}
