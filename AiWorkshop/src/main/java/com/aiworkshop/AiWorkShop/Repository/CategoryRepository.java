package com.aiworkshop.AiWorkShop.Repository;

import com.aiworkshop.AiWorkShop.Model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
}