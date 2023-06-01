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

    @ManyToMany
    @JoinTable(
            name = "Post_comment",
            joinColumns = @JoinColumn(name = "comment_id"),
            inverseJoinColumns = @JoinColumn(name = "post_id")
    )
    private Set<Comment> comments= new HashSet<>();

    private LocalDateTime postTime;

    protected Post() {}

    public Post(String content, Profil author, Set<Profil> profilLike, Set<Comment> comments, LocalDateTime postTime) {
        this.content = content;
        this.author = author;
        this.profilLike = profilLike;
        this.comments = comments;
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

    public Set<Comment> getComments() {
        return comments;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }

}
