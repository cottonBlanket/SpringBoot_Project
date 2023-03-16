package com.skb_lab_proj.springboot_project.dal.repositories;

import com.skb_lab_proj.springboot_project.logic.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
    Optional<User> findByEmail(String email);
}