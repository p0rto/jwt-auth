package com.p0rto.jwt_auth.controller; 

import org.springframework.web.bind.annotation.GetMapping; 
import org.springframework.web.bind.annotation.RequestMapping; 
import org.springframework.web.bind.annotation.RestController; 

@RestController 
@RequestMapping("/api/health") 
public class HelloController { 
    @GetMapping 
    public String teste() { 
        return "Api ok."; 
    } 
}