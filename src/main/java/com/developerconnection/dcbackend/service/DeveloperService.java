package com.developerconnection.dcbackend.service;

import com.developerconnection.dcbackend.domain.Developer;
import com.developerconnection.dcbackend.repository.DeveloperRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeveloperService {

    @Autowired
    DeveloperRepository developerRepository;

    public DeveloperService() {}

    public void createDeveloper(Developer new_developer){
        developerRepository.save(new_developer);
    }

    public Developer getDeveloper(String username) {
        return developerRepository.findById(username).get();

    }

 

}

