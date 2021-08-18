package com.developerconnection.dcbackend.repository;

import java.util.List;

import com.developerconnection.dcbackend.domain.DeveloperPost;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeveloperPostRepository extends CrudRepository<DeveloperPost, Long> {

    // @Query("{ 'developerid': 'DBRef('developer', ObjectId(?0))' }")
    List<DeveloperPost> findByDeveloper_username(String developer_username);

    
}