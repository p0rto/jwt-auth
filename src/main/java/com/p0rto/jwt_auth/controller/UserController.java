package com.p0rto.jwt_auth.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.p0rto.jwt_auth.domain.User;
import com.p0rto.jwt_auth.domain.dto.CreateUserRequestDTO;
import com.p0rto.jwt_auth.domain.dto.CreateUserResponseDTO;
import com.p0rto.jwt_auth.service.UserService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/auth")
public class UserController {
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<CreateUserResponseDTO> create(@RequestBody CreateUserRequestDTO dto) {
        User user = this.userService.createUser(dto);

        return ResponseEntity.status(HttpStatus.CREATED).body(CreateUserResponseDTO.from(user));
    }
    
}
