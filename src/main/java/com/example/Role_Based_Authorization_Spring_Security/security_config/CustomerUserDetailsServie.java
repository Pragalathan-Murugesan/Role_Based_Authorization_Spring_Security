package com.example.Role_Based_Authorization_Spring_Security.security_config;

import com.example.Role_Based_Authorization_Spring_Security.entity.User;
import com.example.Role_Based_Authorization_Spring_Security.repo.UserRepo;
import com.example.Role_Based_Authorization_Spring_Security.security_config.CustomUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerUserDetailsServie implements UserDetailsService {
    @Autowired
    private UserRepo userRepo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepo.findByUsername(username);

        return user.map(CustomUserDetails::new)
                .orElseThrow(()->new UsernameNotFoundException("Usename not fount excaption"));
    }
}
