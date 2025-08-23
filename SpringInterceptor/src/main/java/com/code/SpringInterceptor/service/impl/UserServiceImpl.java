package com.code.SpringInterceptor.service.impl;

import com.code.SpringInterceptor.entity.User;
import com.code.SpringInterceptor.repository.UserRepository;
import com.code.SpringInterceptor.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    // user repository reference
    private UserRepository userRepository;

    // constructor injection
    UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> userList() {
        return userRepository.findAll();
    }
}
