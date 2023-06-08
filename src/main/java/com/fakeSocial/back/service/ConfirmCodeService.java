package com.fakeSocial.back.service;

import com.fakeSocial.back.dto.received.ConfirmCodeDto;
import com.fakeSocial.back.exception.NoMatchConfirmCodeException;
import com.fakeSocial.back.model.AuthInfo;
import com.fakeSocial.back.model.ConfirmCode;
import com.fakeSocial.back.persistance.AuthInfoRepository;
import com.fakeSocial.back.persistance.ConfirmCodeRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ConfirmCodeService {
    @Autowired
    private ConfirmCodeRepository confirmCodeRepository;

    @Autowired
    private AuthInfoRepository authInfoRepository;
    public String createConfirmCode(AuthInfo authInfo){

        String numberRandom= generateStringInt();
        System.out.println("wwwwwwwwwwww "+numberRandom+" wwwwwwwwwwww");
        ConfirmCode confirmCode=new ConfirmCode(authInfo,numberRandom);

        confirmCodeRepository.save(confirmCode);

        return numberRandom;

    }

    private String generateStringInt(){

        String str = "0123456789";

        StringBuilder s = new StringBuilder(6);

        for (int i = 0; i < 6; i++) {
            int index = (int)(str.length() * Math.random());
            s.append(str.charAt(index));
        }
        return s.toString();
    }

    public boolean checkConfirmCode(ConfirmCodeDto confirmCodeDto) throws EntityNotFoundException, NoMatchConfirmCodeException {

        Optional<AuthInfo> authInfoOpt= authInfoRepository.findByIdentifier(confirmCodeDto.getIdentifier());
        if(authInfoOpt.isEmpty()){
            throw new EntityNotFoundException("there is no auth_info with this identifier");
        }
        Optional<ConfirmCode> confirmCodeOpt=confirmCodeRepository.findByAuthInfo(authInfoOpt.get());
        if (confirmCodeOpt.isEmpty()){
            throw new EntityNotFoundException("there is no confirm_code with this auth_info");
        }
        if(confirmCodeDto.getCode().equals(confirmCodeOpt.get().getNumberRandom())){
            authInfoOpt.get().setVerify(true);
            authInfoRepository.save(authInfoOpt.get());
            confirmCodeRepository.delete(confirmCodeOpt.get());
            return true; 
        }
        throw new NoMatchConfirmCodeException();
    }
}
