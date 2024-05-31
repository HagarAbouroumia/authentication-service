package com.example.utils;

import jakarta.inject.Singleton;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@Singleton
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Constants {
    public static final String CUSTOMER_ALREADY_REGISTERED_MSG = "Customer Already Exists";
    public static final String INVALID_CREDENTIALS_OR_UNREGISTERED_USER =
            "Invalid Credentials or Un registered";
}
