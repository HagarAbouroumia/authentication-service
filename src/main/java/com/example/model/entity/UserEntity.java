package com.example.model.entity;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.serde.annotation.SerdeImport;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "USER")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Introspected
@SerdeImport(UserEntity.class)
public class UserEntity {
    @Id
    @Column(name = "ID", unique = true)
    private String id;

    @Column(name = "FULL_NAME")
    private String fullName;

    @Column(name = "MAIL")
    private String mail;

    @Column(name = "MOBILE_NUMBER")
    private String mobileNumber;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "BIRTH_DATE")
    private String birthDate;
}
