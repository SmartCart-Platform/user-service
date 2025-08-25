package com.smartcart.user_service.repository;

import com.smartcart.user_service.entity.Role;
import com.smartcart.user_service.enums.ERole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}
