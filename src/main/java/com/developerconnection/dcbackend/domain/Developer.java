package com.developerconnection.dcbackend.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="Developer")
public class Developer {

    @Id
    private String username;

    @Column 
    private String email;

    @Column 
    private String password;

    //generated, year account created
    @Column
    private int usersince;

    @Column 
    private String bio;

    @OneToMany
    private List<DeveloperPost> posts;


    public Developer() {}

    public Developer(String username, String email, String password, String bio, int usersince) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.bio = bio;
        this.usersince = usersince;
    
    }

    




    



}