package com.likelion.likelioncrud.postTag.api.dto.response;

import com.likelion.likelioncrud.postTag.domain.PostTag;
import lombok.Builder;

@Builder
public record PostTagResponseDto(
        Long postId,
        String postTitle,
        Long tagId,
        String tagName
) {
    public static PostTagResponseDto from(PostTag postTag) {
        return PostTagResponseDto.builder()
                .postId(postTag.getPost().getPostId())
                .postTitle(postTag.getPost().getTitle())
                .tagId(postTag.getTag().getTagId())
                .tagName(postTag.getTag().getName())
                .build();
    }
}
