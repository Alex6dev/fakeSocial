package com.fakeSocial.back.dto.received;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Length;

public class AuthInfoDto {

    @NotBlank
    private String identifier;

    @NotBlank
    @Length(min=6)
    private String mdp;

    protected AuthInfoDto(){}

    public AuthInfoDto(String identifier, String mdp) {
        this.identifier = identifier;
        this.mdp = mdp;
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
}
