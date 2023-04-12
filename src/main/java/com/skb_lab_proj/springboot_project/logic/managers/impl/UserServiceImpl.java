package com.skb_lab_proj.springboot_project.logic.managers.impl;

import com.skb_lab_proj.springboot_project.dal.user.User;
import com.skb_lab_proj.springboot_project.dal.user.repositories.UserRepository;
import com.skb_lab_proj.springboot_project.logic.managers.UserService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Table;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow();
    }

    @Override
    @Transactional
    public User createUser(User input)
    {
        var a = userRepository.save(input);
        return a;
    }
}
