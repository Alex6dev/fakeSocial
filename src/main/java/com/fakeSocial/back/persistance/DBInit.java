package com.fakeSocial.back.persistance;

import com.fakeSocial.back.model.AuthInfo;
import com.fakeSocial.back.model.Comment;
import com.fakeSocial.back.model.Post;
import com.fakeSocial.back.model.Profil;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class DBInit {
    @Autowired
    private AuthInfoRepository authInfoRepository;

    @PostConstruct
    public void dbInit(){

        Profil profil1=new Profil("alex", "six","France","Lille",0652524257,"alex@gmail.com");
        AuthInfo authInfo1= new AuthInfo("profil1","profil1",profil1);
        Post post1= new Post("first message", profil1, LocalDateTime.now());
        Post post2= new Post("second message", profil1, LocalDateTime.now());

        Profil profil2=new Profil("Mathieu", "delage","France","Lille",0652524257,"mathieu@gmail.com");
        AuthInfo authInfo2= new AuthInfo("profil2","profil2",profil2);
        Post post3= new Post("third message", profil2, LocalDateTime.now());
        Post post4= new Post("fourth message", profil2, LocalDateTime.now());

        post1.addProfilLike(profil1);
        post1.addProfilLike(profil2);


        Comment comment1 = new Comment("first comment",profil2,LocalDateTime.now(),post1);

        comment1.addProfilLike(profil1);
        comment1.addProfilLike(profil2);

        authInfoRepository.save(authInfo1);
        authInfoRepository.save(authInfo2);
    }
}
