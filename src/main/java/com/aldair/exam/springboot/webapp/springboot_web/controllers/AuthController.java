package com.aldair.exam.springboot.webapp.springboot_web.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aldair.exam.springboot.webapp.springboot_web.Models.Dto.LoginRequestDto;
import com.aldair.exam.springboot.webapp.springboot_web.Models.Dto.LoginResponseDto;
import com.aldair.exam.springboot.webapp.springboot_web.Servicios.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final UserService userService;

    public AuthController(UserService userService){
        this.userService = userService;
    }
    @PostMapping("/login")
    public LoginResponseDto login(@Valid @RequestBody LoginRequestDto request){

            return userService.Login(request);
    }


}
