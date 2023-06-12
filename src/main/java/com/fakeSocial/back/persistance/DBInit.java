package com.fakeSocial.back.persistance;

import com.fakeSocial.back.model.AuthInfo;
import com.fakeSocial.back.model.CommentModel;
import com.fakeSocial.back.model.Post;
import com.fakeSocial.back.model.Profile;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Component
public class DBInit {
    @Autowired
    private AuthInfoRepository authInfoRepository;


    @PostConstruct
    public void dbInit(){

        Profile profile1 =new Profile("alex", "six","France","Lille",0652524257,"alex@gmail.com",LocalDate.parse("1994-02-14"));
        AuthInfo authInfo1= new AuthInfo("alex@gmail.com","profile123456", profile1);
        Post post1= new Post("first message", profile1, LocalDateTime.now());
        Post post2= new Post("second message", profile1, LocalDateTime.now());

        Profile profile2 =new Profile("Mathieu", "delage","France","Lille",0652524257,"mathieu@gmail.com",LocalDate.parse("1985-02-02"));
        AuthInfo authInfo2= new AuthInfo("mathieu@gmail.com","profile234567", profile2);
        Post post3= new Post("third message", profile2, LocalDateTime.now());
        Post post4= new Post("fourth message", profile2, LocalDateTime.now());

        post1.addProfilLike(profile1);
        post1.addProfilLike(profile2);


        CommentModel commentModel1 = new CommentModel("first comment", profile1,LocalDateTime.now(),post1);

        commentModel1.addProfilLike(profile1);
        commentModel1.addProfilLike(profile2);

        authInfoRepository.save(authInfo1);
        authInfoRepository.save(authInfo2);
    }
}
