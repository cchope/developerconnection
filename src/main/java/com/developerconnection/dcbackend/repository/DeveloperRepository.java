package com.developerconnection.dcbackend.repository;

import com.developerconnection.dcbackend.domain.Developer;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DeveloperRepository extends CrudRepository<Developer, String> {

}