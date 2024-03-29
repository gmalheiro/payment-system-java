package com.gmalheiro.paymentsystem.dto;

import com.gmalheiro.paymentsystem.entity.User;

public record UserRequest(String name, String email, String password) {


    public User toModel(){
      return new User(name,email,password);
    }

}
