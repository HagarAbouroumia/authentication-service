package com.example.service;

import com.example.mapper.AuthenticationMapper;
import com.example.model.entity.UserEntity;
import com.example.model.request.LoginRequest;
import com.example.model.request.RegisterUserRequest;
import com.example.model.response.LoginResponse;
import com.example.model.response.RegisterUserResponse;
import com.example.repository.UserCrudRepositoryFacade;
import jakarta.inject.Singleton;
import jakarta.ws.rs.BadRequestException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import uk.co.deloitte.banking.http.common.Alt;

import static com.example.utils.Constants.CUSTOMER_ALREADY_REGISTERED_MSG;
import static com.example.utils.Constants.INVALID_CREDENTIALS_OR_UNREGISTERED_USER;

@Singleton
@Slf4j
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserCrudRepositoryFacade userCrudRepositoryFacade;

    public RegisterUserResponse register(RegisterUserRequest registerUserRequest) {
        log.info("Register user request is [{}]", registerUserRequest.toString());
        UserEntity userEntity = null;
        UserEntity savedUserEntity = null;
        String message = "200";
        RegisterUserResponse response;
        try {
            userEntity = AuthenticationMapper.INSTANCE.mapToUserEntity(registerUserRequest);
        } catch (Exception exception) {
            message = exception.getMessage();
            response = AuthenticationMapper.INSTANCE.mapToRegisterUserResponse(savedUserEntity, message);
            log.info("Response is [{}]", response.toString());
            return response;
        }
        try {
            UserEntity userEntity2 = userCrudRepositoryFacade.findByMobileNumber(registerUserRequest.getMobileNumber());
            if (userEntity2  != null) {
                log.error("Customer already registered");
                message = CUSTOMER_ALREADY_REGISTERED_MSG;
                response = AuthenticationMapper.INSTANCE.mapToRegisterUserResponse(savedUserEntity, message);
                log.info("Response is [{}]", response.toString());
                return response;
            }
        } catch (Exception exception) {
            message = exception.getMessage();
            response = AuthenticationMapper.INSTANCE.mapToRegisterUserResponse(savedUserEntity, message);
            log.info("Response is [{}]", response.toString());
            return response;
        }
        try {
            savedUserEntity = userCrudRepositoryFacade.save(userEntity);
        } catch (Exception exception) {
            log.error(exception.getMessage());
            message = exception.getMessage();
            response = AuthenticationMapper.INSTANCE.mapToRegisterUserResponse(savedUserEntity, message);
            log.info("Response is [{}]", response.toString());
            return response;
        }

        response = AuthenticationMapper.INSTANCE.mapToRegisterUserResponse(savedUserEntity, message);
        log.info("Response is [{}]", response.toString());
        return response;
    }

    public LoginResponse login(LoginRequest loginRequest) {
        log.info("Login request is [{}]", loginRequest.toString());
        UserEntity userEntity;
        LoginResponse response;
        String message = "200";
        try {
             userEntity = userCrudRepositoryFacade.findByMobileNumberAndPassword(
                    loginRequest.getMobileNumber(), loginRequest.getPassword());
        } catch (Exception exception) {
            message =exception.getMessage();
            response = AuthenticationMapper.INSTANCE.mapToLoginResponse(message);
            log.info("Response is [{}]", response);
            return response;
        }
        if (userEntity == null) {
            log.error("Customer is not registered");
            message = "Customer is not registered";
            response = AuthenticationMapper.INSTANCE.mapToLoginResponse(message);
            log.info("Response is [{}]", response);
            return response;
        }
        response = AuthenticationMapper.INSTANCE.mapToLoginResponse(message);
        log.info("Response is [{}]", response);
        return response;
    }
}
