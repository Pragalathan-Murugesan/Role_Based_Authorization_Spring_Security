package com.example.Role_Based_Authorization_Spring_Security.apiresponse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Component
public class ApiResponse {
    private String message;
    private  Object status;
    private Object data;
}
