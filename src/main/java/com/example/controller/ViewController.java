package com.example.controller;

import com.example.model.entity.UserEntity;
import com.example.model.response.RegisterUserResponse;
import com.example.service.AuthenticationService;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.authentication.Authentication;
import io.micronaut.security.rules.SecurityRule;
import io.micronaut.security.utils.SecurityService;
import io.micronaut.views.View;

import io.micronaut.security.authentication.Authentication;
import jakarta.inject.Inject;
import lombok.RequiredArgsConstructor;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class ViewController {
    private final AuthenticationService authenticationService;

    @Secured(SecurityRule.IS_ANONYMOUS)
    @View("home")
    @Get()
    public Map<String, Object> index() {
        RegisterUserResponse response = authenticationService.signInWithGoogle();
        Map<String, Object> model = new HashMap<>();
        model.put("userId", response.getUserId());
        return model;
    }
}
