package com.aiworkshop.AiWorkShop.Controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aiworkshop.AiWorkShop.Config.AuthenticationRequest;
import com.aiworkshop.AiWorkShop.Config.AuthenticationResponce;
import com.aiworkshop.AiWorkShop.Config.RegisterRequest;
import com.aiworkshop.AiWorkShop.Services.AuthenticationService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService service;

    @PostMapping("/register")
    public void register(@RequestBody RegisterRequest request) {
        service.register(request);
    }

    @PostMapping("/authenticate")
    public void authenticate(@RequestBody AuthenticationRequest request) {
        service.authenticate(request);
    }
}
