package com.developerconnection.dcbackend.domain;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.*;


@Entity
@Table(name="Post")
public class DeveloperPost {

    @Id
    @GeneratedValue
    private Long postid;

    @Column
    private String title;

    @Column 
    private String description;
    
    @Column
    private String timeframe;

    // date posted

    @ManyToOne
    private Developer developerid;

    public DeveloperPost() {}

    public DeveloperPost(String title, String description, String timeframe, String compensation) {

    } 
}