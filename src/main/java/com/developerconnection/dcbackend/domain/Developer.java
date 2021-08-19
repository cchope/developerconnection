package com.developerconnection.dcbackend.domain;

import java.sql.Date;
import java.time.*;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="developer")
public class Developer {

    @Id
    private String username;
 
    private String email;

    @JsonProperty(access = Access.WRITE_ONLY)
    private String password;

    // generated, year account created
    // @DateTimeFormat(iso = DateTimeFormatter.ofPattern("yyyy"))
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy")
    // @JsonDeserialize(using = LocalDateDeserializer.class)
    // @Temporal(TemporalType.TIME)
    @DateTimeFormat(style = "yyyy")
    private LocalDate usersince;

    private String bio;

    // @DBRef
    // private List<DeveloperPost> posts;


    public Developer() {}

    public Developer(String username, String email, String password, String bio, LocalDate usersince) {
        // String password, String bio, int usersince
        this.username = username;
        this.email = email;
        this.password = password;
        this.bio = bio;
        this.usersince = usersince;
        // this.posts = new ArrayList<DeveloperPost>();
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return this.username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return this.email;
    }

    @JsonIgnore
    public String getPassword() {
        return this.password;
    }

    @JsonIgnore
    public void setPassword(String password) {
        this.password = password;
    }

    public String getBio() {
        return this.bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    // public void addPost(DeveloperPost new_post) {
    //     this.posts.add(new_post);
    // }

    // public List<DeveloperPost> getPosts() {
    //     return this.posts;
    // }

    public LocalDate getUsersince() {
        return this.usersince;
    }

    public void setUsersince(LocalDate usersince) {
        this.usersince = usersince;
    }







    



}