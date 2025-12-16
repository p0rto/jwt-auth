package com.p0rto.jwt_auth.domain.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record CreateUserRequestDTO(
    @NotNull(message = "O email deve ser informado") @Email String email,
    @NotNull(message = "A senha deve ser informada") @Size(min = 6) String password
) {

}
