package com.fakeSocial.back.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
public class CommentModel {

    @Id
    @GeneratedValue
    private Long id;

    private String content;

    @ManyToOne
    @JoinColumn(name = "author_id_comment")
    private Profile authorComment;

    @ManyToMany(mappedBy = "commentModelLike")
    private Set<Profile> profileLike = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post commentPost;


    private LocalDateTime postTime;

    protected CommentModel(){}

    public CommentModel(String content, Profile authorComment, LocalDateTime postTime, Post post) {
        this.content = content;
        this.authorComment = authorComment;
        this.postTime = postTime;
        authorComment.addComment(this);
        this.commentPost=post;
        post.addComment(this);
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

    public Profile getAuthorComment() {
        return authorComment;
    }

    public void setAuthorComment(Profile authorComment) {
        this.authorComment = authorComment;
    }


    public Set<Profile> getProfilLike() {
        return profileLike;
    }

    public void setProfilLike(Set<Profile> profileLike) {
        this.profileLike = profileLike;
    }

    public LocalDateTime getPostTime() {
        return postTime;
    }

    public void setPostTime(LocalDateTime postTime) {
        this.postTime = postTime;
    }

    public Post getCommentPost() {
        return commentPost;
    }

    public void setCommentPost(Post commentPost) {
        this.commentPost = commentPost;
    }

    public void addProfilLike(Profile profile){
        this.profileLike.add(profile);
        profile.addCommentLike(this);
    }
}
