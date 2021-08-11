package com.developerconnection.dcbackend.repository;

import com.developerconnection.dcbackend.domain.Developer;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface DeveloperRepository extends MongoRepository<Developer, String> {
    
}