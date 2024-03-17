package com.aiworkshop.AiWorkShop.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aiworkshop.AiWorkShop.Model.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    
} 
