package com.fakeSocial.back.service;

import com.fakeSocial.back.dto.received.NewAuthInfoProfileDto;
import com.fakeSocial.back.model.AuthInfo;
import com.fakeSocial.back.model.Profile;
import com.fakeSocial.back.persistance.AuthInfoRepository;
import com.fakeSocial.back.persistance.ProfileRepository;
import org.hibernate.engine.jdbc.spi.SqlExceptionHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.time.LocalDate;

@Service
public class AuthInfoService {
    @Autowired
    private AuthInfoRepository authInfoRepository;

    @Autowired
    private ProfileRepository profileRepository;

    public boolean createAuthInfoAndProfil(NewAuthInfoProfileDto newAuthInfoProfileDto) throws   DataIntegrityViolationException {
        Profile profile = new Profile(newAuthInfoProfileDto.getName(), newAuthInfoProfileDto.getFirstName(), newAuthInfoProfileDto.getEmail(),LocalDate.parse(newAuthInfoProfileDto.getDateOfBirth()));
        AuthInfo authInfo= new AuthInfo(newAuthInfoProfileDto.getEmail(), profile);
        authInfoRepository.save(authInfo);
        return true;


    }
}
