package com.likelion.likelioncrud.postTag.domain.repository;

import com.likelion.likelioncrud.post.domain.Post;
import com.likelion.likelioncrud.postTag.domain.PostTag;
import com.likelion.likelioncrud.tag.domain.Tag;

import java.util.List;

public interface PostTagRepository{
    List<PostTag> findByPost(Post post);
    List<PostTag> findByTag(Tag tag);
}
