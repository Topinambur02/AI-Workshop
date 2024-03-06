package com.aiworkshop.AiWorkShop.Controllers;

import com.aiworkshop.AiWorkShop.Model.User;
import com.aiworkshop.AiWorkShop.Repository.UserRepository;
import com.aiworkshop.AiWorkShop.Themes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts/category")
public class PostController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/{theme}")
    public List<User> getPostsByCategory(@PathVariable Themes theme) {
        return userRepository.findByCategoryThemes(theme);
    }
}