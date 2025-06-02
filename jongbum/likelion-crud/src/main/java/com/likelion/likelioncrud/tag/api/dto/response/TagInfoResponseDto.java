package com.likelion.likelioncrud.tag.api.dto.response;

import com.likelion.likelioncrud.tag.domain.Tag;
import lombok.Builder;

@Builder
public record TagInfoResponseDto(
        // Tag가 가지고 있는 정보
        String name,
        boolean hasPosts // 태그가 게시물에 사용되었는지 여부 필드 추가
) {
    public static TagInfoResponseDto from(Tag tag) {
        return TagInfoResponseDto.builder()
                .name(tag.getName())
                .hasPosts(!tag.getPostTags().isEmpty())
                .build();
    }
}