package com.gmalheiro.paymentsystem.controller;

import com.gmalheiro.paymentsystem.dto.UserResponse;
import com.gmalheiro.paymentsystem.service.UserService;
import com.gmalheiro.paymentsystem.dto.UserRequest;
import com.gmalheiro.paymentsystem.entity.User;
import jakarta.mail.MessagingException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<UserResponse> registerUser(@RequestBody @Valid UserRequest userRequest)   throws MessagingException, UnsupportedEncodingException {
        User user = userRequest.toModel();
        UserResponse userSaved = userService.registerUser(user);
        return  ResponseEntity.ok().body(userSaved);
    }

    @GetMapping("/verify")
    public String verifyUser(@Param("code") String code){
        if(userService.verify(code)){
            return "verify_success";
        } else {
            return "verify_fail";
        }
    }

}
