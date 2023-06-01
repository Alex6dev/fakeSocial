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

    @ManyToMany(mappedBy = "commentLike")
    private Set<Profil> profilLike= new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post commentPost;


    private LocalDateTime postTime;

    protected Comment(){}

    public Comment(String content, Profil authorComment, LocalDateTime postTime,Post post) {
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

    public Profil getAuthorComment() {
        return authorComment;
    }

    public void setAuthorComment(Profil authorComment) {
        this.authorComment = authorComment;
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

    public Post getCommentPost() {
        return commentPost;
    }

    public void setCommentPost(Post commentPost) {
        this.commentPost = commentPost;
    }

    public void addProfilLike(Profil profil){
        this.profilLike.add(profil);
        profil.addCommentLike(this);
    }
}
