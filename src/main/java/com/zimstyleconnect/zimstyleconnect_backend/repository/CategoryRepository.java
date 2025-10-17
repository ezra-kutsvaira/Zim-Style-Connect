package com.zimstyleconnect.zimstyleconnect_backend.repository;

import com.zimstyleconnect.zimstyleconnect_backend.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository <Category, Long> {
    boolean existsByName(String name);
}
