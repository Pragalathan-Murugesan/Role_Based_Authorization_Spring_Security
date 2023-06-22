package com.example.Role_Based_Authorization_Spring_Security.service;

import com.example.Role_Based_Authorization_Spring_Security.apiresponse.ApiResponse;
import com.example.Role_Based_Authorization_Spring_Security.dto_class.LoginDto;
import com.example.Role_Based_Authorization_Spring_Security.dto_class.UserDto;
import com.example.Role_Based_Authorization_Spring_Security.entity.User;
import com.example.Role_Based_Authorization_Spring_Security.jwt_tokens.JwtToken;
import com.example.Role_Based_Authorization_Spring_Security.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtToken jwtToken;
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private PasswordEncoder encoder;
    @Autowired
    private ApiResponse apiResponse;
       public ApiResponse addUser(UserDto userDto){
           try {
               User user = new User();
               user.setUsername(userDto.getUsername());
               user.setEmailID(userDto.getEmailID());
               user.setRole(userDto.getRole());
               user.setPassword(encoder.encode(userDto.getPassword()));
               userRepo.save(user);
               apiResponse.setMessage("Data Added Successfully");
               apiResponse.setStatus(HttpStatus.CREATED.value());
               apiResponse.setData(null);
           }catch (NullPointerException e){
               throw new NullPointerException();
           }

           return apiResponse;
       }

    public ApiResponse login(LoginDto loginDto) {
           try {
               Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDto.getUsername(), loginDto.getPassword()));
               if (authentication.isAuthenticated()) {
                   String token = jwtToken.generateToken(loginDto.getUsername());
                   apiResponse.setData(token);
                   apiResponse.setStatus(HttpStatus.OK.value());
                   apiResponse.setMessage("LoginSuccessfully");
                   return apiResponse;
               } else {
                   apiResponse.setData(null);
                   apiResponse.setStatus(HttpStatus.NOT_FOUND.value());
                   apiResponse.setMessage("Login Failed");
                   return apiResponse;
               }
           }catch (NullPointerException e){
               throw new NullPointerException();
           } catch (Exception e) {
               throw new RuntimeException(e);
           }
    }
    public ApiResponse getAll() {
           try {

               List<User> user = userRepo.findAll();
               apiResponse.setMessage("Data Received");
               apiResponse.setStatus(HttpStatus.OK);
               apiResponse.setData(user);
           }catch (NullPointerException e){
               throw new NullPointerException();
           }
         return apiResponse;
    }

    public ApiResponse update(UserDto userDto) {
           try {
               User user = userRepo.findByEmailID(userDto.getEmailID());
                   user.setRole(userDto.getRole());
                   userRepo.save(user);
                   apiResponse.setData(null);
                   apiResponse.setStatus(HttpStatus.OK.value());
                   apiResponse.setMessage("Data Update Successfully");
           }catch (NullPointerException e){
               throw new NullPointerException();
           }
           return apiResponse;
    }

    public ApiResponse getByName(String username) {
           try {
               Optional<User> user = userRepo.findByUsername(username);
               apiResponse.setMessage("GetByUsername Field");
               apiResponse.setStatus(HttpStatus.OK.value());
               apiResponse.setData(user);
           }catch (NullPointerException e){
               throw new NullPointerException();
           }
           return apiResponse;
    }
}