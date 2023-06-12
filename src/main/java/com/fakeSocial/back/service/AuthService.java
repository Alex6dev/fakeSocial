package com.fakeSocial.back.service;

import com.fakeSocial.back.BackApplication;
import com.fakeSocial.back.dto.issued.ProfileDto;
import com.fakeSocial.back.dto.received.AuthInfoDto;
import com.fakeSocial.back.exception.ForbiddenException;
import com.fakeSocial.back.model.AuthInfo;
import com.fakeSocial.back.model.Profile;
import com.fakeSocial.back.persistance.AuthInfoRepository;
import com.fakeSocial.back.persistance.ProfileRepository;
import jakarta.persistence.EntityNotFoundException;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {
    @Autowired
    private AuthInfoRepository authInfoRepository;

    @Autowired
    private ProfileRepository profileRepository;

    private static final Logger logger = BackApplication.logger;


    public ProfileDto getAuthentication(AuthInfoDto authInfoDto) throws EntityNotFoundException, ForbiddenException {
        Optional<AuthInfo> authInfoOpt= authInfoRepository.findByIdentifier(authInfoDto.getIdentifier());
        if(authInfoOpt.isEmpty()){
            throw new EntityNotFoundException("there is no auth_info with this identifier");
        } else if (!authInfoOpt.get().getMdp().equals(authInfoDto.getMdp())) {
            throw new ForbiddenException("the couple identification password is not the correct one");
        }

        Optional<Profile> profileOpt= profileRepository.findByAuthInfo(authInfoOpt.get());
        if(profileOpt.isEmpty()){
            throw new EntityNotFoundException("there is no auth_info with this identifier");
        }

        logger.info("user successfully logged in !");
        return new ProfileDto(profileOpt.get());

    }

}
