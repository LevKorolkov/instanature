package com.levkorolkov.application.payload.request;

import lombok.Data;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;

@Data
@Getter
public class LoginRequest {

    @NotEmpty(message = "Username cannot be empty")
    private String username;
    @NotEmpty(message = "Password cannot be empty")
    private String password;

}
