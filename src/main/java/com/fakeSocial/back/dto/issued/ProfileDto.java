package com.fakeSocial.back.dto.issued;

import com.fakeSocial.back.model.Profile;

import java.time.LocalDate;

public class ProfileDto {
    private Long id;

    private String name;

    private String firstName;

    private String country;

    private String city;

    private Integer phone;

    private String email;

    private LocalDate dateOfBirth;

    protected ProfileDto() {}

    public ProfileDto(Profile profile){
        this.id=profile.getId();
        this.name= profile.getName();
        this.firstName= profile.getFirstName();
        this.country=profile.getCountry();
        this.city= profile.getCity();
        this.phone=profile.getPhone();
        this.email= profile.getEmail();
        this.dateOfBirth=profile.getDateOfBirth();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
