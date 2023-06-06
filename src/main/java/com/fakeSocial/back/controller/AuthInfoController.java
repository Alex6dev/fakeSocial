package com.fakeSocial.back.controller;

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

    @PostMapping("newAuthInfo")
    private ResponseEntity newAuthInfoController(@Valid @RequestBody NewAuthInfoProfileDto newAuthInfoProfileDto){
        try {
            return ResponseEntity.ok().body(authInfoService.createAuthInfoAndProfil(newAuthInfoProfileDto));
        }catch (DataIntegrityViolationException e){
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }
}
