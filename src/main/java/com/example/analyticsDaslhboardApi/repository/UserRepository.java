package com.example.analyticsDaslhboardApi.repository;

import com.example.analyticsDaslhboardApi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
