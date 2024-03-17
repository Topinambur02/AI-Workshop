package com.aiworkshop.AiWorkShop.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.aiworkshop.AiWorkShop.Config.AuthenticationRequest;
import com.aiworkshop.AiWorkShop.Config.AuthenticationResponce;
import com.aiworkshop.AiWorkShop.Config.RegisterRequest;
import com.aiworkshop.AiWorkShop.Model.Role;
import com.aiworkshop.AiWorkShop.Model.User;
import com.aiworkshop.AiWorkShop.Repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    @Autowired
    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    
    public AuthenticationResponce register(RegisterRequest request) {
        var user = User.builder()
            .login(request.getLogin())
            .email(request.getEmail())
            .password(passwordEncoder.encode(request.getPassword()))
            .role(Role.USER)
            .build();
        
        repository.save(user);
        var jwtToken = jwtService.generateToken(user);

        return AuthenticationResponce
                .builder()
                .token(jwtToken)
                .build();
    }

    public AuthenticationResponce authenticate(AuthenticationRequest request) {

        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(request.getLogin(), request.getPassword())
        );

        var user = repository.findByLogin(request.getLogin()).orElseThrow();

        var jwtToken = jwtService.generateToken(user);

        return AuthenticationResponce
                .builder()
                .token(jwtToken)
                .build();
    }
}
