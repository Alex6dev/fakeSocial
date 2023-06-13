package com.fakeSocial.back.persistance;

import com.fakeSocial.back.model.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PostPagingRepository extends PagingAndSortingRepository<Post,Long> {
    Page<Post> findAll(Pageable pageable);

}
