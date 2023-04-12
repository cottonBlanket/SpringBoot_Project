package com.skb_lab_proj.springboot_project.dal.solution.repositories;

import com.skb_lab_proj.springboot_project.dal.solution.Solution;
import com.skb_lab_proj.springboot_project.dal.user.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SolutionRepository extends JpaRepository<Solution, Long> {
}
