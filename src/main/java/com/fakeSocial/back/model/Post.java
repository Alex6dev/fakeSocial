package com.fakeSocial.back.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Post {

    @Id
    @GeneratedValue
    private Long id;

    private String content;
    @ManyToOne
    @JoinColumn(name = "author_id")
    private Profile author;

    @ManyToMany(mappedBy = "postLike")
    private Set<Profile> profileLike = new HashSet<>();

    @OneToMany(mappedBy = "commentPost")
    private Set<CommentModel> postCommentModels = new HashSet<>();

    private LocalDateTime postTime;

    private byte[] image;

    protected Post() {}

    public Post(String content, Profile author, LocalDateTime postTime) {
        this.content = content;
        this.author = author;
        this.postTime = postTime;
        author.addPost(this);
    }
    public Post(String content, Profile author, LocalDateTime postTime,byte[] image) {
        this.content = content;
        this.author = author;
        this.postTime = postTime;
        author.addPost(this);
        this.image=image;
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

    public Profile getAuthor() {
        return author;
    }

    public void setAuthor(Profile author) {
        this.author = author;
    }

    public LocalDateTime getPostTime() {
        return postTime;
    }

    public void setPostTime(LocalDateTime postTime) {
        this.postTime = postTime;
    }

    public Set<Profile> getProfileLike() {
        return profileLike;
    }

    public void setProfileLike(Set<Profile> profileLike) {
        this.profileLike = profileLike;
    }

    public Set<CommentModel> getPostCommentModels() {
        return postCommentModels;
    }

    public void setPostCommentModels(Set<CommentModel> postCommentModels) {
        this.postCommentModels = postCommentModels;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public void addProfilLike(Profile profile){
        this.profileLike.add(profile);
        profile.addPostLike(this);
    }
    public void addComment(CommentModel commentModel){
        this.postCommentModels.add(commentModel);
    }
}
