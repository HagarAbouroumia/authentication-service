package com.example.repository;

import com.example.model.entity.UserEntity;
import io.lettuce.core.dynamic.annotation.Param;
import io.micronaut.data.annotation.Query;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.model.query.builder.sql.Dialect;
import io.micronaut.data.repository.CrudRepository;

import javax.swing.text.html.Option;
import java.util.Optional;

@Repository
public interface UserCrudRepository extends CrudRepository<UserEntity, String> {

    Optional<UserEntity> findByMobileNumberAndPassword(String mobileNumber, String password);

    Optional<UserEntity> findByMobileNumber(String mobileNumber);
}
