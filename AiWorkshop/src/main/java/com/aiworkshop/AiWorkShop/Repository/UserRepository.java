package com.aiworkshop.AiWorkShop.Repository;

import com.aiworkshop.AiWorkShop.Themes;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.aiworkshop.AiWorkShop.Model.User;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
    List<User> findByCategoryThemes(Themes theme);
}
