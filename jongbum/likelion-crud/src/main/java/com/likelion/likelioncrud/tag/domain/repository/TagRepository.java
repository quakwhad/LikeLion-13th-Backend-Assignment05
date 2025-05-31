package com.likelion.likelioncrud.tag.domain.repository;

import com.likelion.likelioncrud.post.domain.Post;
import com.likelion.likelioncrud.tag.domain.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TagRepository extends JpaRepository<Tag, Long> {
}
