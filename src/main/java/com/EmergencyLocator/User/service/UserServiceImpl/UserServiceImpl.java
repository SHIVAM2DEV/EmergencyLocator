package com.EmergencyLocator.User.service.UserServiceImpl;

import com.EmergencyLocator.User.entity.User;
import com.EmergencyLocator.User.repository.UserRepo;
import com.EmergencyLocator.User.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepo userRepo;

    @Override
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    @Override
    public User saveUser(User user) {
        return userRepo.save(user);
    }
}
