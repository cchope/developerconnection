package com.developerconnection.dcbackend.service;

import java.util.List;

import com.developerconnection.dcbackend.domain.DeveloperPost;
import com.developerconnection.dcbackend.repository.DeveloperPostRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeveloperPostService {

    @Autowired
    DeveloperPostRepository postRepository;

    public DeveloperPostService() {}

    public void createDeveloperPost(DeveloperPost new_post){
        postRepository.save(new_post);
    }

    public DeveloperPost getDeveloperPost(Long id) {
        return postRepository.findById(id).get();

    }

    public List<DeveloperPost> getAllDeveloperPosts(String developer_username){
        return postRepository.findByDeveloper_username(developer_username);
    }

 

}
