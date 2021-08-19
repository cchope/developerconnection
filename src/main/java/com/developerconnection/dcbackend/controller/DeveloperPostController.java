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
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeveloperPostController {

    @Autowired 
    DeveloperPostService postService;

    @Autowired
    DeveloperService developerService;
 

    @PostMapping("/developer/{username}/dcpost")
    public ResponseEntity<DeveloperPost> createDeveloperPost(@PathVariable String username, @RequestBody DeveloperPost new_post) {
        Developer developer = developerService.getDeveloper(username);
        new_post.setDeveloper(developer);
        new_post.setPostdate(LocalDateTime.now());
        return new ResponseEntity<>(postService.createDeveloperPost(new_post), HttpStatus.OK);
    }    
    
    @GetMapping("/developer/{username}/dcpost/")
    public List<DeveloperPost> getDeveloperPosts(@PathVariable String username) {
        return postService.getAllDeveloperPosts(username);
    }

    @GetMapping("/developer/{username}/dcpost/{postid}")
    public DeveloperPost getDeveloperPost(@PathVariable String username, @PathVariable Long postid) {
        return postService.getDcPost(postid);
    }

    @PutMapping("/developer/{username}/dcpost/{postid}")
    public ResponseEntity<DeveloperPost> updateDeveloperPost(@PathVariable String username, @PathVariable Long postid, @RequestBody DeveloperPost updatedDeveloperPost){
        return new ResponseEntity<>(postService.updateDeveloperPost(postid, updatedDeveloperPost), HttpStatus.OK);
    }


    @DeleteMapping("developer/{username}/dcpost/{postid}")
    public void deleteDeveloper(@PathVariable String username, @PathVariable Long postid){
        postService.deleteDeveloperPost(postid);
        System.out.println("Post Deleted");
    }










}


