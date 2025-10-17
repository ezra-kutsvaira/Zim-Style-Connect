package com.zimstyleconnect.zimstyleconnect_backend.repository;

import com.zimstyleconnect.zimstyleconnect_backend.entity.Interaction;
import com.zimstyleconnect.zimstyleconnect_backend.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import com.zimstyleconnect.zimstyleconnect_backend.entity.User;
import java.util.List;

public interface InteractionRepository extends JpaRepository<Interaction, Long> {
    List<Interaction> findByUser(User user);
    List<Interaction> findByProduct(Product product);

}
