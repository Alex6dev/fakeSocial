package com.fakeSocial.back.controller;

import com.fakeSocial.back.BackApplication;
import com.fakeSocial.back.dto.received.GetPostDto;
import com.fakeSocial.back.dto.received.NewPostAndImageDto;
import com.fakeSocial.back.dto.received.NewPostDto;
import com.fakeSocial.back.service.PostService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/")
public class PostController {
    private static final Logger logger = BackApplication.logger;

    @Autowired
    private PostService postService;
    @PostMapping("newPost")
    public ResponseEntity newPost(@Valid @RequestBody NewPostDto newPostDto){
        try{
            postService.newPostDto(newPostDto);
            return ResponseEntity.ok().build();
        }catch (EntityNotFoundException e){
            logger.error("EntityNotFoundException: "+ e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
        } catch(Exception e){
            logger.error("an error occurred while executing the function postController.newPost. Error:500");
            return ResponseEntity.status(HttpStatus.valueOf(500)).build();
        }
    }

    @PostMapping("post")
    public ResponseEntity getPost(@Valid @RequestBody GetPostDto getPostDto){
        try{
            return ResponseEntity.ok().body(postService.getPost(getPostDto));
        }catch (Exception e){
            logger.error("an error occurred while executing the function postController.getPost. Error:500");
            return ResponseEntity.status(HttpStatus.valueOf(500)).build();
        }
    }

    @PostMapping("newPost/image")
    public ResponseEntity newPostAndImage(@Valid @RequestBody NewPostAndImageDto newPostAndImageDto){
        try{
            postService.newPostAndImageDto(newPostAndImageDto);
            return ResponseEntity.ok().build();
        }catch (EntityNotFoundException e){
            logger.error("EntityNotFoundException: "+ e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
        } catch(Exception e){
            logger.error("an error occurred while executing the function postController.newPostAndImage. Error:500");
            return ResponseEntity.status(HttpStatus.valueOf(500)).build();
        }
    }

}
