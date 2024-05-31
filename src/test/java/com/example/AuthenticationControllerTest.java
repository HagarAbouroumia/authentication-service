package com.example;

import com.example.controller.AuthenticationController;
import com.example.model.request.LoginRequest;
import com.example.model.request.RegisterUserRequest;
import com.example.model.response.RegisterUserResponse;
import com.example.repository.UserCrudRepositoryFacade;
import com.example.service.AuthenticationService;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.test.annotation.MockBean;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.example.utils.ModelsTest.buildLoginRequest;
import static com.example.utils.ModelsTest.buildRegisterUserRequest;
import static com.example.utils.ModelsTest.buildRegisterUserResponse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@MicronautTest
class AuthenticationControllerTest {

    @Inject
    AuthenticationService authenticationService;
    @Inject
    AuthenticationController authenticationController;

    @MockBean(AuthenticationService.class)
    AuthenticationService authenticationService() {
        return mock(AuthenticationService.class);
    }

//    @Test
//    @DisplayName("Test register endpoint")
//    void test_register_endpoint() {
//        when(authenticationService.register(any()))
//                .thenReturn(buildRegisterUserResponse());
//
//        HttpResponse<RegisterUserResponse> httpResponse =
//                authenticationController.register(buildRegisterUserRequest());
//
//        assertEquals(httpResponse.getStatus(), HttpStatus.OK);
//        assertNotNull(httpResponse.getBody().orElse(null));
//    }

//    @Test
//    @DisplayName("Test login endpoint")
//    void test_login_endpoint() {
//        doNothing().when(authenticationService)
//                .login(any());
//        HttpResponse<Void> httpResponse =
//                authenticationController.login(buildLoginRequest());
//
//        assertEquals(httpResponse.getStatus(), HttpStatus.OK);
//    }


}
