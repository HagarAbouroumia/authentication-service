package com.example.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.core.annotation.Introspected;
import io.micronaut.serde.annotation.SerdeImport;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Introspected
@SerdeImport(RegisterUserRequest.class)
public class RegisterUserRequest {
    @Schema(name = "FullName")
    @JsonProperty("FullName")
    @NotBlank
    private String fullName;

    @Schema(name = "Mail")
    @JsonProperty("Mail")
    @NotBlank
    private String mail;

    @Schema(name = "MobileNumber")
    @JsonProperty("MobileNumber")
    @NotBlank
    private String mobileNumber;

    @Schema(name = "Password")
    @JsonProperty("Password")
    @NotBlank
    private String password;

    @Schema(name = "BirthDate")
    @JsonProperty("BirthDate")
    @NotBlank
    private String birthDate;

}
