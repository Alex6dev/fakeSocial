package com.fakeSocial.back.controller;

import com.fakeSocial.back.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/api/")
public class AuthController {
    @Autowired
    private AuthService authService;

}
