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

    public Developer createDeveloper(Developer new_developer){
         return developerRepository.save(new_developer);
    }

    public Developer getDeveloper(String username) {
        return developerRepository.findById(username).get();

    }

    public Developer updatDeveloper(String username, Developer updatedDeveloper) {
        Developer developerToUpdate = developerRepository.findById(username).get();
        developerToUpdate.setUsername(updatedDeveloper.getUsername());
        developerToUpdate.setPassword(updatedDeveloper.getPassword());
        developerToUpdate.setEmail(updatedDeveloper.getEmail());
        developerToUpdate.setBio(updatedDeveloper.getBio());
        return developerRepository.save(developerToUpdate);
    }

    public void deleteDeveloper(String username) {
        developerRepository.deleteById(username);
    }


}

