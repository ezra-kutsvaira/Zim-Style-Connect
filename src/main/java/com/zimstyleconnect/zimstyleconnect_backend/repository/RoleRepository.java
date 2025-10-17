package com.zimstyleconnect.zimstyleconnect_backend.repository;

import com.zimstyleconnect.zimstyleconnect_backend.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName (String name);
}
