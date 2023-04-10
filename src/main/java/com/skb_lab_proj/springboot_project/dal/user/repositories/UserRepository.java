package com.skb_lab_proj.springboot_project.dal.user.repositories;

import com.skb_lab_proj.springboot_project.dal.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
