package com.example.repository;

import com.example.model.entity.UserEntity;
import io.micronaut.data.annotation.Query;
import jakarta.inject.Singleton;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.swing.text.html.Option;
import java.util.Optional;

@Slf4j
@Singleton
@RequiredArgsConstructor
public class UserCrudRepositoryFacade {

    public final UserCrudRepository repository;

    public void save(UserEntity userEntity) throws Exception {
        try {
            repository.save(userEntity);
        } catch (Exception exception) {
            throw new Exception(exception.getMessage());
        }
    }

    public UserEntity findByMobileNumberAndPassword(String mobileNumber, String password) throws Exception {
        Optional<UserEntity> userEntity = Optional.empty();
        try {
            userEntity =  repository.findByMobileNumberAndPassword(mobileNumber, password);
        } catch (Exception exception) {
            throw new Exception(exception.getMessage());
        }
        return userEntity.orElse(null);
    }

    public UserEntity findByMobileNumber(String mobileNumber) throws Exception {
        Optional<UserEntity> userEntity = Optional.empty();
        try {
            userEntity =  repository.findByMobileNumber(mobileNumber);
        } catch (Exception exception) {
            throw new Exception(exception.getMessage());
        }
        return userEntity.orElse(null);
    }


}
