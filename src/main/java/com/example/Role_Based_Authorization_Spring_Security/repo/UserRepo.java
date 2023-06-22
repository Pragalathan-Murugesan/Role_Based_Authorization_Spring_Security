package com.example.Role_Based_Authorization_Spring_Security.repo;

import com.example.Role_Based_Authorization_Spring_Security.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User,Long> {
    Optional<User> findByUsername(String username);

    User findByEmailID(String emailID);
}
