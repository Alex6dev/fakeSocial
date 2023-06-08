package com.fakeSocial.back.persistance;

import com.fakeSocial.back.model.AuthInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthInfoRepository extends JpaRepository<AuthInfo,Long> {
    Optional<AuthInfo> findByIdentifierAndMdp(String identifier, String mdp);
    Optional<AuthInfo> findByIdentifier(String identifier);

}
