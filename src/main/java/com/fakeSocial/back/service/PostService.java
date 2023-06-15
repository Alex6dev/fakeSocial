package com.fakeSocial.back.service;

import com.fakeSocial.back.BackApplication;
import com.fakeSocial.back.dto.issued.PostDto;
import com.fakeSocial.back.dto.received.GetPostDto;
import com.fakeSocial.back.dto.received.NewPostAndImageDto;
import com.fakeSocial.back.dto.received.NewPostDto;
import com.fakeSocial.back.model.Post;
import com.fakeSocial.back.model.Profile;
import com.fakeSocial.back.persistance.PostPagingRepository;
import com.fakeSocial.back.persistance.PostRepository;
import com.fakeSocial.back.persistance.ProfileRepository;
import jakarta.persistence.EntityNotFoundException;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private ProfileRepository profileRepository;

    @Autowired
    private PostPagingRepository postPagingRepository;

    private static final Logger logger = BackApplication.logger;

    public void newPostDto(NewPostDto newPostDto)throws EntityNotFoundException{
        Optional<Profile> profileOpt= profileRepository.findById(Long.parseLong(newPostDto.getAuthor()));
        if(profileOpt.isEmpty()){
            throw new EntityNotFoundException("there is no profile with this id");
        }
        Post post = new Post(newPostDto.getContent().trim(),profileOpt.get(), LocalDateTime.now());
        postRepository.save(post);

        logger.info("backup of the message in BDD is carried out");
    }

    public List<PostDto>  getPost(GetPostDto getPostDto){
        //the getPostDto will allow in a next release to search according to the profile
        Pageable pageable= PageRequest.of(getPostDto.getPageNext(), 4, Sort.by(Sort.Direction.DESC, "postTime"));
        Page<Post> list= postPagingRepository.findAll(pageable);
        List<PostDto> listDto= new ArrayList<>(list.getSize());

        for(Post post:list){
            PostDto postDto= new PostDto(post);
            listDto.add(postDto);
        }
        logger.info("send page "+getPostDto.getPageNext()+" (indexFirst: 0 )");
        return listDto;
    }
    public void newPostAndImageDto(NewPostAndImageDto newPostAndImageDtoDto)throws EntityNotFoundException{
        Optional<Profile> profileOpt= profileRepository.findById(Long.parseLong(newPostAndImageDtoDto.getAuthor()));
        if(profileOpt.isEmpty()){
            throw new EntityNotFoundException("there is no profile with this id");
        }
        Post post = new Post(newPostAndImageDtoDto.getContent().trim(),profileOpt.get(), LocalDateTime.now(),newPostAndImageDtoDto.getImage().getBytes());
        postRepository.save(post);

        logger.info("backup of the message in BDD is carried out");
    }
}
