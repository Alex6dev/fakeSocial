package com.fakeSocial.back.controller;

import com.fakeSocial.back.BackApplication;
import com.fakeSocial.back.dto.received.AuthInfoDto;
import com.fakeSocial.back.dto.received.ConfirmCodeDto;
import com.fakeSocial.back.exception.NoMatchConfirmCodeException;
import com.fakeSocial.back.service.ConfirmCodeService;
import jakarta.persistence.EntityNotFoundException;
import org.slf4j.Logger;

import com.fakeSocial.back.dto.received.NewAuthInfoProfileDto;
import com.fakeSocial.back.service.AuthInfoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
@CrossOrigin
@RestController
@RequestMapping("/api/")
public class AuthInfoController {
    @Autowired
    private AuthInfoService authInfoService;

    @Autowired
    private ConfirmCodeService confirmCodeService;

    private static final Logger logger = BackApplication.logger;
    @PostMapping("newAuthInfo")
    public ResponseEntity newAuthInfo(@Valid @RequestBody NewAuthInfoProfileDto newAuthInfoProfileDto){
        try {
            return ResponseEntity.ok().body(authInfoService.createAuthInfoAndProfile(newAuthInfoProfileDto));
        }catch (DataIntegrityViolationException e){
            logger.error("an auth_info already exists with this email");
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }catch (Exception e){
            logger.error("an error occurred while executing the function authInfoController.newAuthInfo. Error:500");
            return ResponseEntity.status(HttpStatus.valueOf(500)).build();
        }
    }

    @PostMapping("confirmCode")
    public ResponseEntity confirmCodeEmail(@Valid @RequestBody ConfirmCodeDto confirmCodeDto){
        try{
            return ResponseEntity.ok().body(confirmCodeService.checkConfirmCode(confirmCodeDto));

        }catch (EntityNotFoundException e){
            logger.error("EntityNotFoundException: "+ e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
        }catch (NoMatchConfirmCodeException e){
            logger.error("NoMatchConfirmCodeException: "+ e.getMessage());
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();

        }catch (Exception e){
            logger.error("an error occurred while executing the function authInfoController.confirmCodeEmail. Error: 500");
            return ResponseEntity.status(HttpStatus.valueOf(500)).build();
        }

    }

    @PutMapping("newAuthInfo")
    public ResponseEntity updateAuthInfoWithPassword(@Valid @RequestBody AuthInfoDto authInfoDto){
        try{
            return ResponseEntity.ok().body(authInfoService.updateAuthInfoWithPassword(authInfoDto));

        }catch(EntityNotFoundException e){
            logger.error("EntityNotFoundException: "+ e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();

        }catch (Exception e){
            logger.error("an error occurred while executing the function authInfoController.updateAuthInfo. Error: 500");
            return ResponseEntity.status(HttpStatus.valueOf(500)).build();
        }
    }
}
