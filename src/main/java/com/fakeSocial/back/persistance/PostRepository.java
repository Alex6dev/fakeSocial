package com.fakeSocial.back.persistance;

import com.fakeSocial.back.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post,Long> {

}
