package com.fakeSocial.back.dto.received;

public class GetPostDto {
    private String userId;

    private Integer pageNext;

    protected  GetPostDto(){}

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getPageNext() {
        return pageNext;
    }

    public void setPageNext(Integer pageNext) {
        this.pageNext = pageNext;
    }
}
