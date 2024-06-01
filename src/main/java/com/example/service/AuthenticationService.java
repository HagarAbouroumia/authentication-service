package com.example.service;

import com.example.mapper.AuthenticationMapper;
import com.example.model.entity.UserEntity;
import com.example.model.request.LoginRequest;
import com.example.model.request.RegisterUserRequest;
import com.example.model.response.LoginResponse;
import com.example.model.response.RegisterUserResponse;
import com.example.repository.UserCrudRepositoryFacade;
import io.micronaut.security.authentication.Authentication;
import jakarta.inject.Singleton;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.security.Principal;
import java.util.UUID;

import static com.example.utils.Constants.CUSTOMER_ALREADY_REGISTERED_MSG;
import static com.example.utils.Constants.CUSTOMER_NOT_REGISTERED;
import static com.example.utils.Constants.INCORRECT_CREDENTIALS;
import static com.example.utils.Constants.SUCCESS_CODE;

@Singleton
@Slf4j
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserCrudRepositoryFacade userCrudRepositoryFacade;

    public RegisterUserResponse register(RegisterUserRequest registerUserRequest) {
        log.info("Register user request is [{}]", registerUserRequest.toString());
        RegisterUserResponse response;
        try {
            if(isUserRegistered(registerUserRequest.getMobileNumber())) {
                response = AuthenticationMapper.INSTANCE.mapToRegisterUserResponse(
                        null, CUSTOMER_ALREADY_REGISTERED_MSG);
                log.info("Register user response [{}]", response.toString());
                return response;
            }
            UserEntity userEntity = AuthenticationMapper.INSTANCE.mapToUserEntity(registerUserRequest);
            userCrudRepositoryFacade.save(userEntity);
            response = AuthenticationMapper.INSTANCE.mapToRegisterUserResponse(userEntity, SUCCESS_CODE);
        } catch (Exception exception) {
            response = AuthenticationMapper.INSTANCE.mapToRegisterUserResponse(null, exception.getMessage());
        }
        log.info("Register user response [{}]", response.toString());
        return response;
    }

    public LoginResponse login(LoginRequest loginRequest) {
        log.info("Login request is [{}]", loginRequest.toString());
        LoginResponse response;
        try {
            if (!isUserRegistered(loginRequest.getMobileNumber())) {
                response = AuthenticationMapper.INSTANCE.mapToLoginResponse(CUSTOMER_NOT_REGISTERED, null);
                log.info("Login user response [{}]", response.toString());
                return response;
            }
            if (!isCredentialsCorrect(loginRequest)) {
                response = AuthenticationMapper.INSTANCE.mapToLoginResponse(INCORRECT_CREDENTIALS, null);
                log.info("Login user response [{}]", response.toString());
                return response;
            }
            UserEntity userEntity = userCrudRepositoryFacade.findByMobileNumber(loginRequest.getMobileNumber());
            response = AuthenticationMapper.INSTANCE.mapToLoginResponse(SUCCESS_CODE, userEntity.getId());
        } catch (Exception exception) {
            response = AuthenticationMapper.INSTANCE.mapToLoginResponse(exception.getMessage(), null);
        }
        log.info("Login user response [{}]", response.toString());
        return response;
    }

    private boolean isUserRegistered(String mobileNumber) throws Exception {
        UserEntity userEntity = userCrudRepositoryFacade.findByMobileNumber(mobileNumber);
        return userEntity != null;
    }

    private boolean isCredentialsCorrect(LoginRequest loginRequest) throws Exception {
        UserEntity userEntity = userCrudRepositoryFacade.findByMobileNumberAndPassword(
                loginRequest.getMobileNumber(), loginRequest.getPassword());
        return userEntity != null;
    }

    public RegisterUserResponse signInWithGoogle() {
        RegisterUserRequest registerUserRequest = RegisterUserRequest.builder()
                .fullName("googleCustomer")
                .birthDate("googleCustomer")
                .mail("googleCustomer")
                .mobileNumber(UUID.randomUUID().toString())
                .password("googleCustomer")
                .build();
        return register(registerUserRequest);
    }
}
