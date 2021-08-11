package com.developerconnection.dcbackend.domain;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;



@Document
public class Developer {

    @Id
    private String username;
 
    private String email;

    // private String password;

    // // //generated, year account created
    // private int usersince;

    // private String bio;

    // private List<DeveloperPost> posts;


    public Developer() {}

    public Developer(String username, String email) {
        // String password, String bio, int usersince
        this.username = username;
        this.email = email;
        // this.password = password;
        // this.bio = bio;
        // this.usersince = usersince;
    
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


    




    



}