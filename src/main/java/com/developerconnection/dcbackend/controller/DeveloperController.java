package com.developerconnection.dcbackend.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import com.developerconnection.dcbackend.domain.Developer;
import com.developerconnection.dcbackend.domain.DeveloperPost;
import com.developerconnection.dcbackend.repository.DeveloperRepository;
import com.developerconnection.dcbackend.service.DeveloperPostService;
import com.developerconnection.dcbackend.service.DeveloperService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeveloperController {


    // @Autowired 
    // DeveloperRepository developerRepository;

    @Autowired
    DeveloperService developerService;

    @Autowired 
    DeveloperPostService postService;

    @PostMapping(value="/developer", consumes = "application/json",
    produces = "application/json")
    public ResponseEntity<Developer> createDeveloper(@RequestBody Developer new_dev) {
        new_dev.setUsersince(LocalDate.now());
        // developerService.createDeveloper(new_dev);
        return new ResponseEntity<>(developerService.createDeveloper(new_dev), HttpStatus.OK);
    }

    @GetMapping("/developer/{username}")
    public Developer getDeveloper(@PathVariable String username) {
        return developerService.getDeveloper(username);
    }

    @PostMapping("/developer/{username}/dcpost")
    public void createDeveloperPost(@PathVariable String username, @RequestBody DeveloperPost new_post) {
        Developer developer = developerService.getDeveloper(username);
        // developer.addPost(new_post);
        // ObjectId developer_id = username;
        new_post.setDeveloper(developer);
        new_post.setPostdate(LocalDateTime.now());
        postService.createDeveloperPost(new_post);
    }

    @GetMapping("/developer/{username}/dcpost")
    public List<DeveloperPost> getDeveloperPosts(@PathVariable String username) {
        return postService.getAllDeveloperPosts(username);
    }




    // @PutMapping("/developer/{username}")
    // public Developer updatDeveloper(@PathVariable String username, @RequestBody Developer updatDeveloper) {

    // }




    

    


}