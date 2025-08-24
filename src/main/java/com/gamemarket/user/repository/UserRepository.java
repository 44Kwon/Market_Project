package com.gamemarket.user.repository;

import com.gamemarket.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByUsername(String username);
    boolean existsByIdAndRole(Long userId, User.Role role);
}
