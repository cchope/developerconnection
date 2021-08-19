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

    public DeveloperPost createDeveloperPost(DeveloperPost new_post){
        return postRepository.save(new_post);
    }

    public DeveloperPost getDcPost(Long id) {
        return postRepository.findById(id).get();

    }

    public List<DeveloperPost> getAllDeveloperPosts(String developer_username){
        return postRepository.findByDeveloper_username(developer_username);
    }


    public DeveloperPost updateDeveloperPost(Long postid,  DeveloperPost updatedPost) {
        DeveloperPost developerPostToUpdate = postRepository.findById(postid).get();
        developerPostToUpdate.setTitle(updatedPost.getTitle());
        developerPostToUpdate.setDescription(updatedPost.getDescription());
        developerPostToUpdate.setRole(updatedPost.getRole());
        developerPostToUpdate.setAvailability(updatedPost.getAvailablity());
        developerPostToUpdate.setCompensation(updatedPost.getCompensation());
        return postRepository.save(developerPostToUpdate);
    }

    public void deleteDeveloperPost(Long postid) {
        postRepository.deleteById(postid);
    }




}
