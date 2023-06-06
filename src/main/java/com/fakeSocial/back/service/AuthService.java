package com.fakeSocial.back.service;

import com.fakeSocial.back.dto.issued.ProfilDto;
import com.fakeSocial.back.dto.received.AuthInfoDto;
import com.fakeSocial.back.persistance.AuthInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired
    private AuthInfoRepository authInfoRepository;

    public ProfilDto getAuthentication(AuthInfoDto authInfoDto){
        return new ProfilDto();
    }

}
