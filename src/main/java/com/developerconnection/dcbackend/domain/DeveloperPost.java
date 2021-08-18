package com.developerconnection.dcbackend.domain;

import java.time.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Id;

enum Role {
    GIVEHELP, GETHELP
}

@Entity
@Table(name="dcpost")
public class DeveloperPost {

    @Id
    @GeneratedValue
    private Long postid;

    private String title;

    private Role role;

    private String description;
    
    private String timeframe;

    private String availability;

    private String compensation;

    private LocalDateTime postdate;

    @ManyToOne
    @JoinColumn(name="username")
    private Developer developer;

    public DeveloperPost() {}

    public DeveloperPost(String title, Role role, String description, String availability, String timeframe, String compensation) {
        this.title = title;
        this.role = role;
        this.description = description;
        this.availability = availability;
        this.timeframe = timeframe;
        this.compensation = compensation;
    } 

    public Long getId() {
        return this.postid;
    }

    public String getTitle() {
        return this.title;
    }


    public Developer getDeveloper() {
        return this.developer;
    } 

    public void setDeveloper(Developer developer) {
        this.developer = developer;
    }


    public void setTitle(String title){
        this.title=title;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTimeframe() {
        return this.timeframe;
    }

    public void setTimeframe(String timeframe) {
        this.timeframe = timeframe;
    }


    public String getCompensation() {
        return this.compensation;
    }

    public void setCompensation(String compensation) {
        this.compensation = compensation;
    }

    public String getAvailablity() {
        return this.availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    public Role getRole() {
        return this.role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public LocalDateTime getPostdate() {
        return this.postdate;
    }

    public void setPostdate(LocalDateTime postdate) {
        this.postdate = postdate;
    }

}