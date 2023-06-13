package com.fakeSocial.back.dto.received;

import jakarta.validation.constraints.NotBlank;

public class NewPostDto {

    @NotBlank
    private String content;

    @NotBlank
    private String author;

    protected NewPostDto() {}

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
}
