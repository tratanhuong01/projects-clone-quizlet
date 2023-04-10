package com.quizlet.app.service.userService;

import com.quizlet.app.dto.UserDTO;
import com.quizlet.app.model.account.User;

import java.util.List;

public interface UserService {
    User saveUser(UserDTO userDTO);
    User findByUserName(String userName);
    List<User> findAllUsers();
}
