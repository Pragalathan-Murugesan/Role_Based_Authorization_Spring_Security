package com.example.Role_Based_Authorization_Spring_Security.dto_class;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDto {
    private String username;
    private String emailID;
    private String password;
    private String role;
}
