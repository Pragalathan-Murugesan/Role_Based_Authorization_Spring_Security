package com.example.Role_Based_Authorization_Spring_Security.controller;

import com.example.Role_Based_Authorization_Spring_Security.apiresponse.ApiResponse;
import com.example.Role_Based_Authorization_Spring_Security.dto_class.LoginDto;
import com.example.Role_Based_Authorization_Spring_Security.dto_class.UserDto;
import com.example.Role_Based_Authorization_Spring_Security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping(value = "/post")
    public ApiResponse addUser(@RequestBody UserDto userDto){
        return userService.addUser(userDto);
    }
    @PostMapping(value = "/login")
    public ApiResponse login(@RequestBody LoginDto loginDto){
       return userService.login(loginDto);
    }
    @GetMapping(value = "/getbyid/{name}")
    public ApiResponse getByName(@PathVariable("name") String username){
        return userService.getByName(username);
    }
    @GetMapping(value = "/get")
    @PreAuthorize("hasAuthority('User')")
    public String get(){
        return "This Is A";
    }
}
