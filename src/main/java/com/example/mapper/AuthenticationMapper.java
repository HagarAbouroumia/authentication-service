package com.example.mapper;

import com.example.model.entity.UserEntity;
import com.example.model.request.RegisterUserRequest;
import com.example.model.response.LoginResponse;
import com.example.model.response.RegisterUserResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.UUID;

@Mapper()
public interface AuthenticationMapper {
    AuthenticationMapper INSTANCE = Mappers.getMapper(AuthenticationMapper.class);

    default UserEntity mapToUserEntity(RegisterUserRequest userInfo) {
        return UserEntity.builder()
                .id(UUID.randomUUID().toString())
                .fullName(userInfo.getFullName())
                .mail(userInfo.getMail())
                .mobileNumber(userInfo.getMobileNumber())
                .password(userInfo.getPassword())
                .birthDate(userInfo.getBirthDate())
                .build();
    }

    default RegisterUserResponse mapToRegisterUserResponse(UserEntity userEntity, String message) {
        if (userEntity == null) {
            return RegisterUserResponse.builder()
                    .fullName(null)
                    .mobileNumber(null)
                    .message(message)
                    .build();
        }
        return RegisterUserResponse.builder()
                .fullName(userEntity.getFullName())
                .mobileNumber(userEntity.getMobileNumber())
                .userId(userEntity.getId())
                .message(message)
                .build();
    }

    default LoginResponse mapToLoginResponse(String message, String userId) {
        return LoginResponse.builder()
                .message(message)
                .userId(userId)
                .build();
    }
}
