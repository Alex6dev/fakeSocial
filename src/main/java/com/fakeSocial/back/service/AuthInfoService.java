package com.fakeSocial.back.service;

import com.fakeSocial.back.dto.received.NewAuthInfoProfileDto;
import com.fakeSocial.back.model.AuthInfo;
import com.fakeSocial.back.model.ConfirmCode;
import com.fakeSocial.back.model.Profile;
import com.fakeSocial.back.persistance.AuthInfoRepository;
import com.fakeSocial.back.persistance.ConfirmCodeRepository;
import com.fakeSocial.back.persistance.ProfileRepository;
import com.fakeSocial.back.sendMail.EmailServiceImpl;
import org.hibernate.engine.jdbc.spi.SqlExceptionHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Random;

@Service
public class AuthInfoService {
    @Autowired
    private AuthInfoRepository authInfoRepository;

    @Autowired
    private ProfileRepository profileRepository;

    @Autowired
    private EmailServiceImpl emailService;

   @Autowired
   private ConfirmCodeService confirmCodeService;


    public boolean createAuthInfoAndProfile(NewAuthInfoProfileDto newAuthInfoProfileDto) throws   DataIntegrityViolationException {
        Profile profile = new Profile(newAuthInfoProfileDto.getName(), newAuthInfoProfileDto.getFirstName(), newAuthInfoProfileDto.getEmail(),LocalDate.parse(newAuthInfoProfileDto.getDateOfBirth()));
        AuthInfo authInfo= new AuthInfo(newAuthInfoProfileDto.getEmail(), profile);
        authInfoRepository.save(authInfo);

        confirmCodeService.createConfirmCode(authInfo);
        //send email with confirm code email
        //emailService.sendSimpleMessage(newAuthInfoProfileDto.getEmail(), "code test", confirmCodeService.createConfirmCode(authInfo));

        return true;
    }



}
