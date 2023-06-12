package com.fakeSocial.back.persistance;

import com.fakeSocial.back.model.AuthInfo;
import com.fakeSocial.back.model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProfileRepository extends JpaRepository<Profile,Long> {
    Optional<Profile> findByAuthInfo(AuthInfo authInfo);

}
