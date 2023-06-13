package com.fakeSocial.back.service;

import com.fakeSocial.back.BackApplication;
import com.fakeSocial.back.dto.issued.PostDto;
import com.fakeSocial.back.dto.received.NewPostDto;
import com.fakeSocial.back.model.Post;
import com.fakeSocial.back.model.Profile;
import com.fakeSocial.back.persistance.PostRepository;
import com.fakeSocial.back.persistance.ProfileRepository;
import jakarta.persistence.EntityNotFoundException;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private ProfileRepository profileRepository;

    private static final Logger logger = BackApplication.logger;

    public PostDto newPostDto(NewPostDto newPostDto)throws EntityNotFoundException{
        Optional<Profile> profileOpt= profileRepository.findById(Long.parseLong(newPostDto.getAuthor()));
        if(profileOpt.isEmpty()){
            throw new EntityNotFoundException("there is no profile with this id");
        }
        Post post = new Post(newPostDto.getContent().trim(),profileOpt.get(), LocalDateTime.now());
        post= postRepository.save(post);

        logger.info("backup of the message in BDD is carried out");

        return new PostDto(post);
    }
}
