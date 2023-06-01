package com.fakeSocial.back.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Comment {

    @Id
    @GeneratedValue
    private Long id;

    private String content;

    @ManyToOne
    @JoinColumn(name = "author_id_comment")
    private Profil authorComment;

    @ManyToMany(mappedBy = "comments")
    private Set<Profil> comments= new HashSet<>();

    @ManyToMany(mappedBy = "commentLike")
    private Set<Profil> profilLike= new HashSet<>();

    @ManyToMany(mappedBy = "comments")
    private Set<Post> commentPost= new HashSet<>();
    private LocalDateTime postTime;

    protected Comment(){}

    public Comment(String content, Profil authorComment, Set<Profil> comments, Set<Profil> profilLike, Set<Post> commentPost, LocalDateTime postTime) {
        this.content = content;
        this.authorComment = authorComment;
        this.comments = comments;
        this.profilLike = profilLike;
        this.commentPost = commentPost;
        this.postTime = postTime;
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

    public Profil getAuthorComment() {
        return authorComment;
    }

    public void setAuthorComment(Profil authorComment) {
        this.authorComment = authorComment;
    }

    public Set<Profil> getComments() {
        return comments;
    }

    public void setComments(Set<Profil> comments) {
        this.comments = comments;
    }

    public Set<Profil> getProfilLike() {
        return profilLike;
    }

    public void setProfilLike(Set<Profil> profilLike) {
        this.profilLike = profilLike;
    }

    public LocalDateTime getPostTime() {
        return postTime;
    }

    public void setPostTime(LocalDateTime postTime) {
        this.postTime = postTime;
    }

    public Set<Post> getCommentPost() {
        return commentPost;
    }

    public void setCommentPost(Set<Post> commentPost) {
        this.commentPost = commentPost;
    }
}
