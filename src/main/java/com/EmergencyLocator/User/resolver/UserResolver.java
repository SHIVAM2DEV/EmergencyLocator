package com.EmergencyLocator.User.resolver;

import com.EmergencyLocator.User.entity.User;
import com.EmergencyLocator.User.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserResolver {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<User> saveUser(@RequestBody  User user ){
        return ResponseEntity.ok(userService.saveUser(user));
    }

    @GetMapping
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @PutMapping
    public User editUser(@RequestBody User user){
        return userService.editUser(user);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
        return ResponseEntity.ok("User Deleted Sucessfully");
    }
}
