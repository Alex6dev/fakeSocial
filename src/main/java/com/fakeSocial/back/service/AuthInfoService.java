package com.fakeSocial.back.service;

import com.fakeSocial.back.BackApplication;
import com.fakeSocial.back.dto.received.AuthInfoDto;
import com.fakeSocial.back.dto.received.NewAuthInfoProfileDto;
import com.fakeSocial.back.model.AuthInfo;
import com.fakeSocial.back.model.Profile;
import com.fakeSocial.back.persistance.AuthInfoRepository;
import com.fakeSocial.back.persistance.ProfileRepository;
import jakarta.persistence.EntityNotFoundException;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

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

   private static final Logger logger = BackApplication.logger;


    public boolean createAuthInfoAndProfile(NewAuthInfoProfileDto newAuthInfoProfileDto) throws   DataIntegrityViolationException {
        Profile profile = new Profile(newAuthInfoProfileDto.getName(), newAuthInfoProfileDto.getFirstName(), newAuthInfoProfileDto.getEmail(),LocalDate.parse(newAuthInfoProfileDto.getDateOfBirth()));
        AuthInfo authInfo= new AuthInfo(newAuthInfoProfileDto.getEmail(), profile);
        authInfoRepository.save(authInfo);

        //send email with confirm code email

        //region use code in business premises OPEN because not use sendEmail
        confirmCodeService.createConfirmCode(authInfo);
        //endregion

        //region use code outside business premises OPEN because not use sendEmail
        //emailService.sendSimpleMessage(newAuthInfoProfileDto.getEmail(), "code test", confirmCodeService.createConfirmCode(authInfo));
        //endregion

        logger.info("creation of the auth_info went well, name: "+profile.getName()+" and firstName: "+profile.getFirstName());
        return true;
    }

    public boolean updateAuthInfoWithPassword(AuthInfoDto authInfoDto) throws EntityNotFoundException{
        Optional<AuthInfo> authInfoOpt= authInfoRepository.findByIdentifier(authInfoDto.getIdentifier());
        if(authInfoOpt.isEmpty()){
            throw new EntityNotFoundException("there is no auth_info with this identifier");
        }
        AuthInfo authInfo= authInfoOpt.get();
        authInfo.setMdp(authInfoDto.getMdp());
        authInfoRepository.save(authInfo);

        logger.info("password implementation of the new Auth_info is done");
        return true;
    }

}
