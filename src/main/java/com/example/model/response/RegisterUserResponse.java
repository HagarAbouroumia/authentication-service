package com.example.model.response;

import com.example.model.request.RegisterUserRequest;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.core.annotation.Introspected;
import io.micronaut.serde.annotation.SerdeImport;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Introspected
@SerdeImport(RegisterUserResponse.class)
public class RegisterUserResponse {
    @Schema(name = "FullName")
    @JsonProperty("FullName")
    private String fullName;

    @Schema(name = "MobileNumber")
    @JsonProperty("MobileNumber")
    private String mobileNumber;

    @Schema(name = "Message")
    @JsonProperty("Message")
    private String message;

    @Schema(name = "UserId")
    @JsonProperty("UserId")
    private String userId;


}
