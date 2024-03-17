package com.aiworkshop.AiWorkShop.Controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aiworkshop.AiWorkShop.Exceptions.IncorrectEmail;
import com.aiworkshop.AiWorkShop.Exceptions.ResourceNotFoundException;
import com.aiworkshop.AiWorkShop.Model.User;
import com.aiworkshop.AiWorkShop.Repository.UserRepository;

@RestController
@RequestMapping("/api/")
public class UserController {
    private static Logger logger = Logger.getLogger(UserController.class.getName());

    @Autowired
    private UserRepository userRepository;

    // get users

    @GetMapping("users")
    public List<User> getAllUsers () {
        return this.userRepository.findAll();
    }

    // save user

    @PostMapping("/users")
    public void createUser(@RequestBody User user) {
        this.userRepository.save(user);
        logger.info("Successful addition of a user to the database");
    }

    // update user

    @PutMapping("users/{id}")
    public ResponseEntity<User> updateUser(@PathVariable(value = "id") Long userId, @RequestBody User userdDetails) throws ResourceNotFoundException, IncorrectEmail {
        User user = userRepository.findById(userId).orElseThrow(
            () -> new ResourceNotFoundException("User not found for this id :: " + userId));

        user.setEmail(userdDetails.getEmail());
        user.setLogin(userdDetails.getLogin());
        user.setPassword(userdDetails.getPassword());

        return ResponseEntity.ok(this.userRepository.save(user));

    }

    // delete user

    @DeleteMapping("users/{id}")
    public Map<String, Boolean> deleteUser(@PathVariable(value = "id") Long userId) throws ResourceNotFoundException {
        User user = userRepository.findById(userId).orElseThrow(
            () -> new ResourceNotFoundException("User not found for this id :: " + userId));
        
        this.userRepository.delete(user);

        Map<String, Boolean> responce = new HashMap<>();

        responce.put("deleted", Boolean.TRUE);

        return responce;
    }
}
