package com.example.utils;

import com.example.model.entity.UserEntity;
import com.example.model.request.LoginRequest;
import com.example.model.request.RegisterUserRequest;
import com.example.model.response.RegisterUserResponse;

import static com.example.utils.ConstantsTest.BIRTH_DATE;
import static com.example.utils.ConstantsTest.FULL_NAME;
import static com.example.utils.ConstantsTest.ID;
import static com.example.utils.ConstantsTest.MAIL;
import static com.example.utils.ConstantsTest.MOBILE_NUMBER;
import static com.example.utils.ConstantsTest.PASSWORD;

public class ModelsTest {

    public static RegisterUserRequest buildRegisterUserRequest() {
        return RegisterUserRequest.builder()
                .fullName(FULL_NAME)
                .mail(MAIL)
                .mobileNumber(MOBILE_NUMBER)
                .password(PASSWORD)
                .birthDate(BIRTH_DATE)
                .build();
    }

    public static UserEntity buildUserEntity() {
        return UserEntity.builder()
                .id(ID)
                .fullName(FULL_NAME)
                .mail(MAIL)
                .mobileNumber(MOBILE_NUMBER)
                .password(PASSWORD)
                .birthDate(BIRTH_DATE)
                .build();
    }

    public static LoginRequest buildLoginRequest() {
        return LoginRequest.builder()
                .mobileNumber(MOBILE_NUMBER)
                .password(PASSWORD)
                .build();
    }

    public static RegisterUserResponse buildRegisterUserResponse() {
        return RegisterUserResponse.builder()
                .fullName(FULL_NAME)
                .mobileNumber(MOBILE_NUMBER)
                .build();
    }
}
