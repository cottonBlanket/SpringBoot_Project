package com.skb_lab_proj.springboot_project.dal.user;

import com.skb_lab_proj.springboot_project.dal.base.BaseCRUDRepository;
import com.skb_lab_proj.springboot_project.logic.entities.User;
import org.springframework.stereotype.Component;

@Component
public class UserRepository extends BaseCRUDRepository<User, Long> {

}
