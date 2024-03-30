package com.gmalheiro.paymentsystem.controller;

import com.gmalheiro.paymentsystem.dto.UserResponse;
import com.gmalheiro.paymentsystem.service.UserService;
import com.gmalheiro.paymentsystem.dto.UserRequest;
import com.gmalheiro.paymentsystem.entity.User;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<UserResponse> registerUser(@RequestBody @Valid UserRequest userRequest){
        User user = userRequest.toModel();
        UserResponse userSaved = userService.registerUser(user);
        return  ResponseEntity.ok().body(userSaved);
    }
}
