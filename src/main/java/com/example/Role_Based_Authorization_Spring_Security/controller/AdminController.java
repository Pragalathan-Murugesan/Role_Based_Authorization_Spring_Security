package com.example.Role_Based_Authorization_Spring_Security.controller;

import com.example.Role_Based_Authorization_Spring_Security.apiresponse.ApiResponse;
import com.example.Role_Based_Authorization_Spring_Security.dto_class.UserDto;
import com.example.Role_Based_Authorization_Spring_Security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private UserService userService;
    @GetMapping(value = "/getall")
    @PreAuthorize("hasAuthority('Admin')")
    public ApiResponse getAll(){
        return userService.getAll();
    }

    @PutMapping(value = "/update1")
    @PreAuthorize("hasAuthority('Admin')")
    public ApiResponse update(@RequestBody UserDto userDto){
        return userService.update(userDto);
    }

    @GetMapping(value = "/home")
    @PreAuthorize("hasAuthority('Admin')")
    public String home(){
        return "this login";
    }
}
