package com.fakeSocial.back.dto.issued;

import com.fakeSocial.back.model.CommentModel;
import com.fakeSocial.back.model.Post;
import com.fakeSocial.back.model.Profile;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

public class PostDto {

    private Long id;
    private String content;
    private ProfileSmallDto author;
    private int profileLike;

    private int postComment;
    private LocalDateTime postTime;

    protected PostDto(){}

    public PostDto(Post post){
        this.id= post.getId();
        this.content= post.getContent();
        this.author=new ProfileSmallDto(post.getAuthor());
        this.profileLike=post.getProfilLike().size();
        this.postComment=post.getPostComments().size();
        this.postTime=post.getPostTime();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public ProfileSmallDto getAuthor() {
        return author;
    }

    public void setAuthor(ProfileSmallDto author) {
        this.author = author;
    }

    public int getProfileLike() {
        return profileLike;
    }

    public void setProfileLike(int profileLike) {
        this.profileLike = profileLike;
    }

    public int getPostComment() {
        return postComment;
    }

    public void setPostComment(int postComment) {
        this.postComment = postComment;
    }

    public LocalDateTime getPostTime() {
        return postTime;
    }

    public void setPostTime(LocalDateTime postTime) {
        this.postTime = postTime;
    }
}
