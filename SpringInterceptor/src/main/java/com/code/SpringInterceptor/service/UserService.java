package com.code.SpringInterceptor.service;


import com.code.SpringInterceptor.entity.User;

import java.util.List;

public interface UserService {

    // add user method
    User addUser(User user);

    // get all user method
    List<User> userList();

}
