package com.fakeSocial.back.persistance;

import com.fakeSocial.back.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment,Long> {
}
