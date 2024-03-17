package com.aiworkshop.AiWorkShop.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aiworkshop.AiWorkShop.Model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
    Optional<User> findByLogin(String login);
}
