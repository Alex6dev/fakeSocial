package com.fakeSocial.back.controller;

import com.fakeSocial.back.BackApplication;
import com.fakeSocial.back.dto.received.ConfirmCodeDto;
import com.fakeSocial.back.service.ConfirmCodeService;
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
    public ResponseEntity newAuthInfoController(@Valid @RequestBody NewAuthInfoProfileDto newAuthInfoProfileDto){
        try {
            return ResponseEntity.ok().body(authInfoService.createAuthInfoAndProfile(newAuthInfoProfileDto));
        }catch (DataIntegrityViolationException e){
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }

    @PostMapping("confirmCode")
    public ResponseEntity confirmCodeEmail(@Valid @RequestBody ConfirmCodeDto confirmCodeDto){
        return ResponseEntity.ok().body(confirmCodeService.checkConfirmCode(confirmCodeDto));

    }
}
