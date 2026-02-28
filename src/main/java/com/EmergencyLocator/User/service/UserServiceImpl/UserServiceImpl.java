package com.EmergencyLocator.User.service.UserServiceImpl;

import com.EmergencyLocator.User.entity.User;
import com.EmergencyLocator.User.repository.UserRepo;
import com.EmergencyLocator.User.service.UserService;
import com.EmergencyLocator.security.configs.WebSecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private WebSecurityConfig webSecurityConfig;

    @Override
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    @Override
    public User saveUser(User user) {
        User setUser = User.builder()
                .id(user.getId())
                .username(user.getUsername())
                .age(user.getAge())
                .phone(user.getPhone())
                .email(user.getEmail())
                .password(webSecurityConfig.passwordEncoder().encode(user.getPassword()))
                .bloodGroup(user.getBloodGroup())
                .emergencyContact(user.getEmergencyContact())
                .createdAt(user.getCreatedAt())
                .build();
        return userRepo.save(setUser);
    }

    @Override
    public User editUser(User user) {
        User setUser = User.builder()
                .id(user.getId())
                .username(user.getUsername())
                .age(user.getAge())
                .phone(user.getPhone())
                .email(user.getEmail())
                .password(webSecurityConfig.passwordEncoder().encode(user.getPassword()))
                .bloodGroup(user.getBloodGroup())
                .emergencyContact(user.getEmergencyContact())
                .createdAt(user.getCreatedAt())
                .build();
       return userRepo.save(setUser);

    }

    @Override
    public void deleteUser(Long id) {
        userRepo.deleteById(id);
    }


}
