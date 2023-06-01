package com.fakeSocial.back.persistance;

import com.fakeSocial.back.model.CommentModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<CommentModel,Long> {
}
