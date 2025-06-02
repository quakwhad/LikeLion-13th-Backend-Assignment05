package com.likelion.likelioncrud.postTag.domain.repository;

import com.likelion.likelioncrud.post.domain.Post;
import com.likelion.likelioncrud.postTag.domain.PostTag;
import com.likelion.likelioncrud.tag.domain.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostTagRepository extends JpaRepository<PostTag, Long> {
    /*
    List<PostTag> findByPost(Post post);
    List<PostTag> findByTag(Tag tag);
    */
}
