package com.fakeSocial.back.dto.received;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

import java.time.LocalDate;

public class NewAuthInfoProfileDto {
    @NotBlank
    private String name;

    @NotBlank
    private String firstName;

    @Email
    private String email;

    @Pattern(regexp = "^[0-9]{4}[-]{1}[0-9]{2}[-]{1}[0-9]{2}$")
    private String dateOfBirth;

    protected NewAuthInfoProfileDto() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
