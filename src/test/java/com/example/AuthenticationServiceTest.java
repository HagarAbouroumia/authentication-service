package com.example;

import com.example.model.response.RegisterUserResponse;
import com.example.repository.UserCrudRepositoryFacade;
import com.example.service.AuthenticationService;
import io.micronaut.runtime.EmbeddedApplication;
import io.micronaut.test.annotation.MockBean;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.ws.rs.BadRequestException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import jakarta.inject.Inject;

import static com.example.utils.ConstantsTest.CUSTOMER_ALREADY_REGISTERED_MSG;
import static com.example.utils.ConstantsTest.FULL_NAME;
import static com.example.utils.ConstantsTest.INVALID_CREDENTIALS_OR_UNREGISTERED_USER;
import static com.example.utils.ConstantsTest.MOBILE_NUMBER;
import static com.example.utils.ModelsTest.buildLoginRequest;
import static com.example.utils.ModelsTest.buildRegisterUserRequest;
import static com.example.utils.ModelsTest.buildUserEntity;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@MicronautTest
class AuthenticationServiceTest {

    @Inject
    EmbeddedApplication<?> application;
    @Inject
    UserCrudRepositoryFacade userCrudRepositoryFacade;
    @Inject
    AuthenticationService authenticationService;

    @MockBean(UserCrudRepositoryFacade.class)
    UserCrudRepositoryFacade userCrudRepositoryFacade() {
        return mock(UserCrudRepositoryFacade.class);
    }

    @Test
    void testItWorks() {
        Assertions.assertTrue(application.isRunning());
    }

    @Test
    @DisplayName("Test register with success")
    void test_register_with_success() throws Exception {
        doNothing().when(userCrudRepositoryFacade)
                .save(any());

        when(userCrudRepositoryFacade.findByMobileNumberAndPassword(any(), any()))
                .thenReturn(buildUserEntity());

        when(userCrudRepositoryFacade.findByMobileNumber(any()))
                .thenReturn(buildUserEntity());

        doNothing().when(userCrudRepositoryFacade)
                .save(any());

        RegisterUserResponse response =
                authenticationService.register(buildRegisterUserRequest());
        assertEquals(response.getFullName(), FULL_NAME);
        assertEquals(response.getMobileNumber(), MOBILE_NUMBER);
    }

    @Test
    @DisplayName("Test register with exception")
    void test_register_with_exception() throws Exception {
        doNothing().when(userCrudRepositoryFacade)
                .save(any());

        when(userCrudRepositoryFacade.findByMobileNumberAndPassword(any(), any()))
                .thenReturn(buildUserEntity());

        when(userCrudRepositoryFacade.findByMobileNumber(any()))
                .thenReturn(buildUserEntity());
        try {
            authenticationService.register(buildRegisterUserRequest());
        } catch (Exception exception) {
            assertEquals(exception.getMessage(), CUSTOMER_ALREADY_REGISTERED_MSG);
        }
    }

//    @Test
//    @DisplayName("Test login with success")
//    void test_login_with_success() throws Exception {
//        doNothing().when(userCrudRepositoryFacade)
//                .save(any());
//
//        when(userCrudRepositoryFacade.findByMobileNumberAndPassword(any(), any()))
//                .thenReturn(buildUserEntity());
//
//        when(userCrudRepositoryFacade.findByMobileNumber(any()))
//                .thenReturn(buildUserEntity());
//        Assertions.assertDoesNotThrow(() -> authenticationService.login(buildLoginRequest()));
//    }
//
//    @Test
//    @DisplayName("Test login with exception")
//    void test_login_with_exception() {
//        when(userCrudRepositoryFacade.findByMobileNumberAndPassword(any(), any()))
//                .thenReturn(null);
//        try {
//            authenticationService.login(buildLoginRequest());
//        } catch (Exception exception) {
//            assertEquals(exception.getMessage(), INVALID_CREDENTIALS_OR_UNREGISTERED_USER);
//        }
//
//    }

}
