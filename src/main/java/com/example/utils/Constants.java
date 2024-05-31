package com.example.utils;

import jakarta.inject.Singleton;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@Singleton
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Constants {
    public static final String CUSTOMER_ALREADY_REGISTERED_MSG = "Customer Already Exists";
    public static final String CUSTOMER_NOT_REGISTERED = "Customer is not registered";
    public static final String INCORRECT_CREDENTIALS = "Incorrect credentials";
    public static final String SUCCESS_CODE = "200";
}
