package com.fakeSocial.back.model;

import jakarta.persistence.*;

@Entity
public class AuthInfo {
    @Id
    @GeneratedValue
    private Long id;

    private String identifier;

    private String mdp;
    
    @OneToOne(mappedBy = "authInfo", cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
    private Profil profil;

    protected AuthInfo( ) {
    }

    public AuthInfo(String identifier, String mdp, Profil profil) {
        this.identifier = identifier;
        this.mdp = mdp;
        this.profil = profil;
        profil.setAuthInfo(this);
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

    public Profil getProfil() {
        return profil;
    }

    public void setProfil(Profil profil) {
        this.profil = profil;
    }
}
