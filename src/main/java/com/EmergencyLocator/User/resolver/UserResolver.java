package com.EmergencyLocator.User.resolver;

import com.EmergencyLocator.User.entity.User;
import com.EmergencyLocator.User.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserResolver {

    @Autowired
    private UserService userService;

    @PostMapping
    public User saveUser(@RequestBody  User user ){
        return userService.saveUser(user);
    }

    @GetMapping
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }
}
