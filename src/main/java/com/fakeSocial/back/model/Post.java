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
    private Profil author;

    @ManyToMany(mappedBy = "postLike")
    private Set<Profil> profilLike= new HashSet<>();

    @OneToMany(mappedBy = "commentPost")
    private Set<Comment> postComments= new HashSet<>();

    private LocalDateTime postTime;

    protected Post() {}

    public Post(String content, Profil author,LocalDateTime postTime) {
        this.content = content;
        this.author = author;
        this.postTime = postTime;
        author.addPost(this);
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

    public Profil getAuthor() {
        return author;
    }

    public void setAuthor(Profil author) {
        this.author = author;
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

    public Set<Comment> getPostComments() {
        return postComments;
    }

    public void setPostComments(Set<Comment> postComments) {
        this.postComments = postComments;
    }

    public void addProfilLike(Profil profil){
        this.profilLike.add(profil);
        profil.addPostLike(this);
    }
    public void addComment(Comment comment){
        this.postComments.add(comment);
    }
}
