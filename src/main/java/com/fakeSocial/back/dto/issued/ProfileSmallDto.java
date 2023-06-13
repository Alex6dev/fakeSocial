package com.fakeSocial.back.dto.issued;

import com.fakeSocial.back.model.Profile;

public class ProfileSmallDto {
    private Long id;

    private String name;

    private String firstName;

    protected ProfileSmallDto(){}

    public ProfileSmallDto(Profile profile){
        this.id= profile.getId();
        this.name= profile.getName();
        this.firstName= profile.getFirstName();
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
}
