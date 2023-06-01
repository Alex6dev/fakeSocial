package com.fakeSocial.back.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Profil {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String firstName;

    private String country;

    private String city;

    private Integer phone;

    private String email;

    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "auth_info_id",unique = true)
    private AuthInfo authInfo;

    @OneToMany(mappedBy = "author",cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
    private Set<Post> posts= new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "Profil_post_like",
            joinColumns = @JoinColumn(name = "post_like_id"),
            inverseJoinColumns = @JoinColumn(name = "profil_id_like")
    )
    private Set<Post> postLike= new HashSet<>();

    @OneToMany(mappedBy = "authorComment",cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
    private Set<Comment> comments= new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "Profil_comment_like",
            joinColumns = @JoinColumn(name = "comment_like_id"),
            inverseJoinColumns = @JoinColumn(name = "profil_id_like")
    )
    private Set<Comment> commentLike= new HashSet<>();

    protected Profil() {}

    public Profil(String name, String firstName, String country, String city, Integer phone, String email) {
        this.name = name;
        this.firstName = firstName;
        this.country = country;
        this.city = city;
        this.phone = phone;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public AuthInfo getAuthInfo() {
        return authInfo;
    }

    public void setAuthInfo(AuthInfo authInfo) {
        this.authInfo = authInfo;
    }

    public Set<Post> getPosts() {
        return posts;
    }

    public void setPosts(Set<Post> posts) {
        this.posts = posts;
    }

    public Set<Post> getPostLike() {
        return postLike;
    }

    public void setPostLike(Set<Post> postLike) {
        this.postLike = postLike;
    }

    public Set<Comment> getComments() {
        return comments;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }



    public void addPost(Post post){
        this.posts.add(post);
    }
    public void addPostLike(Post post){
        this.postLike.add(post);
    }
    public void addComment(Comment comment){
        this.comments.add(comment);
    }
    public void addCommentLike (Comment comment){
        this.commentLike.add(comment);
    }
}
