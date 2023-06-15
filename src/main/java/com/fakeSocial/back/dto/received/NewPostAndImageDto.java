package com.fakeSocial.back.dto.received;

import jakarta.validation.constraints.NotBlank;

public class NewPostAndImageDto {

    @NotBlank
    private String content;

    @NotBlank
    private String author;

    @NotBlank
    private String image;
    protected NewPostAndImageDto() {}

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
