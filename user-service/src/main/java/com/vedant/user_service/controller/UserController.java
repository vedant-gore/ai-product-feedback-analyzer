package com.vedant.user_service.controller;

import com.vedant.user_service.dto.UserDto;
import com.vedant.user_service.model.User;
import com.vedant.user_service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/health")
    public ResponseEntity<String> healthCheck() {
        return ResponseEntity.ok("User Service is up!");
    }

    @PostMapping("create")
    public ResponseEntity<String> createUser(@RequestBody User userDetails){
        System.out.println("Received: " + userDetails);
        return userService.createUser(userDetails);
    }

    @GetMapping("get/{userId}")
    public ResponseEntity<?> getUserById(@PathVariable Long userId){
        return userService.getUserById(userId);
    }

    @GetMapping("all")
    public ResponseEntity<List<User>> getAllUsers(){
        return userService.getAllUsers();
    }

    @PutMapping("update/{userId}")
    public ResponseEntity<String> updateUser(@PathVariable Long userId, @RequestBody UserDto userDto){
        return userService.updateUser(userId, userDto);
    }

    @DeleteMapping("delete/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable Long userId){
        return userService.deleteUser(userId);
    }

}
