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
public class DeveloperController {


    // @Autowired 
    // DeveloperRepository developerRepository;

    @Autowired
    DeveloperService developerService;

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


    @PutMapping("/developer/{username}")
    public ResponseEntity<Developer> updateDeveloper(@PathVariable String username, @RequestBody Developer updatedDeveloper){
        return new ResponseEntity<>(developerService.updateDeveloper(username, updatedDeveloper), HttpStatus.OK);
    }


    @DeleteMapping("developer/{username}")
    public void deleteDeveloper(@PathVariable String username){
        developerService.deleteDeveloper(username);
        System.out.println("Developer Deleted");
    }


}