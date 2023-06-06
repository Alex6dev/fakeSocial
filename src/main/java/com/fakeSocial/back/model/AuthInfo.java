package com.fakeSocial.back.model;

import jakarta.persistence.*;

@Entity
public class AuthInfo {
    @Id
    @GeneratedValue
    private Long id;

    private String identifier;

    private String mdp;

    private Boolean verify=false;

    @OneToOne(mappedBy = "authInfo", cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
    private Profile profile;

    protected AuthInfo( ) {
    }

    public AuthInfo(String identifier, String mdp, Profile profile) {
        this.identifier = identifier;
        this.mdp = mdp;
        this.profile = profile;
        profile.setAuthInfo(this);
    }

    public AuthInfo(String identifier, Profile profile) {
        this.identifier = identifier;
        this.profile = profile;
        profile.setAuthInfo(this);

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public Profile getProfil() {
        return profile;
    }

    public void setProfil(Profile profile) {
        this.profile = profile;
    }

    public Boolean getVerify() {
        return verify;
    }

    public void setVerify(Boolean verify) {
        this.verify = verify;
    }
}
