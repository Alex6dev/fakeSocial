package com.fakeSocial.back.persistance;

import com.fakeSocial.back.model.AuthInfo;
import com.fakeSocial.back.model.ConfirmCode;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ConfirmCodeRepository extends JpaRepository<ConfirmCode,Long> {
    Optional<ConfirmCode> findByAuthInfo(AuthInfo authInfo);
}
