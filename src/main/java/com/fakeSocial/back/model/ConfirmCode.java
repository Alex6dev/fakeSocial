package com.fakeSocial.back.model;

import jakarta.persistence.*;

@Entity
public class ConfirmCode {

    @Id
    @GeneratedValue
    private Long id;

    @OneToOne
    @JoinColumn(name = "auth_info_id")
    private AuthInfo authInfo;
    private String numberRandom;

    protected ConfirmCode() {}

    public ConfirmCode(AuthInfo authInfo, String numberRandom) {
        this.authInfo = authInfo;
        this.numberRandom = numberRandom;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AuthInfo getAuthInfo() {
        return authInfo;
    }

    public void setAuthInfo(AuthInfo authInfo) {
        this.authInfo = authInfo;
    }

    public String getNumberRandom() {
        return numberRandom;
    }

    public void setNumberRandom(String numberRandom) {
        this.numberRandom = numberRandom;
    }
}
