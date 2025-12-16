package com.p0rto.jwt_auth.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.p0rto.jwt_auth.domain.User;
import com.p0rto.jwt_auth.domain.dto.CreateUserRequestDTO;
import com.p0rto.jwt_auth.repository.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User createUser(CreateUserRequestDTO dto) {
        if (this.userRepository.existsByEmail(dto.email())) {
            throw new IllegalArgumentException("Já existe um usuário para o e-mail informado.");
        }
        
        String encodedPassword = passwordEncoder.encode(dto.password());
        User newUser = User.create(dto.email(), encodedPassword);

        return this.userRepository.save(newUser);
    }
}
