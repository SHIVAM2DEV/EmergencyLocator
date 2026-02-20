package com.EmergencyLocator.User.service;

import com.EmergencyLocator.User.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {
    public List<User> getAllUsers();

    User saveUser(User user);

    void deleteUser(Long id);

    User editUser(User user);
}
