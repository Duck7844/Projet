package com.example.GoogleLoginLast.Repository;

import com.example.GoogleLoginLast.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
