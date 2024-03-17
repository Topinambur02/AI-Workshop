package com.aiworkshop.AiWorkShop.Controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aiworkshop.AiWorkShop.Exceptions.ResourceNotFoundException;
import com.aiworkshop.AiWorkShop.Model.Post;
import com.aiworkshop.AiWorkShop.Repository.PostRepository;

@RestController
@RequestMapping("/api/post")
public class PostController {
    
    @Autowired
    private PostRepository postRepository;

    // save post

    @PostMapping("/save")
    public void createPost(@RequestBody Post post) {
        this.postRepository.save(post);
    }

    // delete post

    @DeleteMapping("/delete/{id}")
    public Map<String, Boolean> deletePost(@PathVariable(value = "id") Long postId) throws ResourceNotFoundException {
        Post post = postRepository.findById(postId).orElseThrow(
            () -> new ResourceNotFoundException("Post not found for this id :: " + postId));
        
        this.postRepository.delete(post);

        Map<String, Boolean> responce = new HashMap<>();

        responce.put("deleted", Boolean.TRUE);

        return responce;
    }
}
