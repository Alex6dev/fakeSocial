package com.fakeSocial.back.service;

import com.fakeSocial.back.dto.issued.ProfilDto;
import com.fakeSocial.back.dto.received.AuthInfoDto;
import com.fakeSocial.back.persistance.AuthInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Service
public class AuthService {
    @Autowired
    private AuthInfoRepository authInfoRepository;

    public ProfilDto getAuthentication(AuthInfoDto authInfoDto){
        return new ProfilDto();
    }

    public static String stringHashSecurity(String mdp) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] encodedhash = digest.digest(mdp.getBytes(StandardCharsets.UTF_8));

        StringBuilder hexString = new StringBuilder(2 * encodedhash.length);
        for (byte b : encodedhash) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }

}
