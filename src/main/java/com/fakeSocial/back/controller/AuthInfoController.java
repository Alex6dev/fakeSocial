package com.fakeSocial.back.controller;

import com.fakeSocial.back.dto.received.NewAuthInfoProfileDto;
import com.fakeSocial.back.service.AuthInfoService;
import jakarta.validation.Valid;
import org.hibernate.engine.jdbc.spi.SqlExceptionHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

@RestController
@RequestMapping("/api/")
public class AuthInfoController {
    @Autowired
    private AuthInfoService authInfoService;

    @PostMapping("newAuthInfo")
    private ResponseEntity newAuthInfoController(@Valid @RequestBody NewAuthInfoProfileDto newAuthInfoProfileDto){
        try {
            return ResponseEntity.ok().body(authInfoService.createAuthInfoAndProfil(newAuthInfoProfileDto));
        }catch (DataIntegrityViolationException e){
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }
}
