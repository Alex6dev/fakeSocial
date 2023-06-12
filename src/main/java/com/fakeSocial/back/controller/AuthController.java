package com.fakeSocial.back.controller;

import com.fakeSocial.back.BackApplication;
import com.fakeSocial.back.dto.received.AuthInfoDto;
import com.fakeSocial.back.exception.ForbiddenException;
import com.fakeSocial.back.service.AuthService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/")
public class AuthController {
    @Autowired
    private AuthService authService;

    private static final Logger logger = BackApplication.logger;

    @PostMapping("authentication")
    public ResponseEntity authentication(@Valid @RequestBody AuthInfoDto authInfoDto){
        try{
            return ResponseEntity.ok(authService.getAuthentication(authInfoDto));
        }catch (EntityNotFoundException e){
            logger.error("EntityNotFoundException: "+ e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
        }catch (ForbiddenException e){
            logger.error("ForbiddenException: "+ e.getMessage());
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        } catch (Exception e){
            logger.error("an error occurred while executing the function authInfoController.updateAuthInfo. Error: 500");
            return ResponseEntity.status(HttpStatus.valueOf(500)).build();
        }
    }

}
