package com.developerconnection.dcbackend.controller;

import com.developerconnection.dcbackend.domain.Developer;
import com.developerconnection.dcbackend.repository.DeveloperRepository;
import com.developerconnection.dcbackend.service.DeveloperService;

import org.springframework.beans.factory.annotation.Autowired;
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

    @PostMapping("/developer")
    public void createDeveloper(@RequestBody Developer new_dev) {
        developerService.createDeveloper(new_dev);
    }

    @GetMapping("/developer/{username}")
    public Developer getDeveloper(@PathVariable String username) {
        return developerService.getDeveloper(username);
    }

    // @PutMapping("/developer/{username}")
    // public Developer updatDeveloper(@PathVariable String username, @RequestBody Developer updatDeveloper) {

    // }




    

    


}