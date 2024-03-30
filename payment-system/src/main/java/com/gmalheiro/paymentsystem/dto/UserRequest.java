package com.gmalheiro.paymentsystem.dto;

import com.gmalheiro.paymentsystem.entity.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record UserRequest(
        @NotNull(message = "Name cannot be null")
        @NotBlank(message = "Name cannot be empty")
        String name,
        @NotNull(message = "Email cannot be null")
        @NotBlank(message = "Email cannot be empty")
        @Email
        String email,
        @NotNull(message = "Password cannot be null")
        @NotBlank(message = "Password cannot be empty")
        @Size(min = 8, message = "Password must contain at least 8 characters")
        String password) {


    public User toModel(){
      return new User(name,email,password);
    }

}
