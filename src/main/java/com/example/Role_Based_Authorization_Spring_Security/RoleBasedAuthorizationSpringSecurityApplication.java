package com.example.Role_Based_Authorization_Spring_Security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;


//@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
@SpringBootApplication
public class RoleBasedAuthorizationSpringSecurityApplication {

	public static void main(String[] args){
		SpringApplication.run(RoleBasedAuthorizationSpringSecurityApplication.class, args);
	}
}
