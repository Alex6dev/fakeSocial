package com.fakeSocial.back.dto.received;


import jakarta.validation.constraints.NotBlank;

public class ConfirmCodeDto {

    @NotBlank
    private String identifier;

    @NotBlank
    private String code;

    protected ConfirmCodeDto() {}

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
