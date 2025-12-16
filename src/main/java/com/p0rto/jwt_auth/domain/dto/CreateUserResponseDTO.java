package com.p0rto.jwt_auth.domain.dto;

import java.util.UUID;

import com.p0rto.jwt_auth.domain.User;

public record CreateUserResponseDTO(
    UUID id,
    String email,
    String role
) {
    public static CreateUserResponseDTO from(User user) {
        return new CreateUserResponseDTO(user.getId(), user.getEmail(), user.getRole());
    }
}
