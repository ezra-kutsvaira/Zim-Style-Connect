package com.zimstyleconnect.zimstyleconnect_backend.repository;
import com.zimstyleconnect.zimstyleconnect_backend.entity.Category;
import com.zimstyleconnect.zimstyleconnect_backend.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByCategory(Category category);
    List<Product> findByNameContainingIgnoreCase(String name);
}
