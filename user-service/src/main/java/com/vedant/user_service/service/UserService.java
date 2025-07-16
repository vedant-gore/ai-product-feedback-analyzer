package com.vedant.user_service.service;

import com.vedant.user_service.dto.UserDto;
import com.vedant.user_service.model.User;
import com.vedant.user_service.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public ResponseEntity<String> createUser(User userDetails){
        try{
            userDao.save(userDetails);
            return new ResponseEntity<>("User Created Successfully!", HttpStatus.CREATED);
        } catch(Exception e){
            System.out.println("Error creating user: " + e);
            return new ResponseEntity<>("Error creating User", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<?> getUserById(Long userId) {
        try {
            boolean userExists = userDao.existsById(userId);
            if (userExists) {
                Optional<User> user = userDao.findById(userId);
                return new ResponseEntity<>(user, HttpStatus.OK);
            } else{
                return new ResponseEntity<>("USER NOT FOUND! USERID DOES NOT EXISTS.", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            System.out.println("User Not Found" + e);
            return new ResponseEntity<>("ERROR OCCURRED WHILE FETCHING USER.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<List<User>> getAllUsers(){
        try{
            List<User> userList = userDao.findAll();
            return ResponseEntity.ok(userList);
        } catch (Exception e){
            System.out.println("Error fetching users" + e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            // return ResponseEntity.internalServerError().build(); -- MORE MODERN FLUENT STYLE
        }
    }

    public ResponseEntity<String> updateUser(Long userId, UserDto user){
        boolean userExists = userDao.existsById(userId);
        if(userExists) {
            userDao.updateUserByUserId(userId, user.getName(), user.getEmail(), user.getTimestamp());
            return ResponseEntity.ok("USER DETAILS UPDATED SUCCESSFULLY!");
        } else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("USER NOT FOUND");
        }
    }

    public ResponseEntity<String> deleteUser(Long userId){
        boolean userExists = userDao.existsById(userId);
        if(userExists){
            userDao.deleteById(userId);
            return ResponseEntity.ok("USER DELETED SUCCESSFULLY!");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("USER NOT FOUND");
        }
    }
}
