package com.skb_lab_proj.springboot_project.dal.user.repositories;

import com.skb_lab_proj.springboot_project.dal.base.BaseRepository;
import com.skb_lab_proj.springboot_project.dal.user.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository extends BaseRepository<User, Long> {

}
