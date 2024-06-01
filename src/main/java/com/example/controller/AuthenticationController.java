package com.example.controller;

import com.example.model.request.LoginRequest;
import com.example.model.request.RegisterUserRequest;
import com.example.model.response.LoginResponse;
import com.example.model.response.RegisterUserResponse;
import com.example.service.AuthenticationService;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.rules.SecurityRule;
import io.micronaut.validation.Validated;
import io.micronaut.views.View;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

import static io.micronaut.http.MediaType.APPLICATION_JSON;

@Controller()
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    @Secured(SecurityRule.IS_ANONYMOUS)
    @Post(value = "/register-user", consumes = APPLICATION_JSON, produces = APPLICATION_JSON)
    public HttpResponse<RegisterUserResponse> register(@Valid @Body RegisterUserRequest registerUserRequest) {
        RegisterUserResponse response = authenticationService.register(registerUserRequest);
        return HttpResponse.ok(response);
    }

    @Secured(SecurityRule.IS_ANONYMOUS)
    @Post(value = "/sign-in", consumes = APPLICATION_JSON, produces = APPLICATION_JSON)
    public HttpResponse<LoginResponse> login(@Valid @Body LoginRequest loginRequest) {
        return HttpResponse.ok(authenticationService.login(loginRequest));
    }

    @Get(value = "/oauth/callback/google")
    public HttpResponse<Void> test() {
        System.out.printf("babeeeeeeeeeeeeeeeeeee");
        return HttpResponse.ok();
    }
}
