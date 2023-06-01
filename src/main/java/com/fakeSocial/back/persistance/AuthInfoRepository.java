package com.fakeSocial.back.persistance;

import com.fakeSocial.back.model.AuthInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthInfoRepository extends JpaRepository<AuthInfo,Long> {
}
