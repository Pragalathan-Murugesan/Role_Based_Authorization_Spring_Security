package com.example.Role_Based_Authorization_Spring_Security.dto_class;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Component
public class LoginDto {
    private String username;
    private String password;
}
