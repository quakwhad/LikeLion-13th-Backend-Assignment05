package com.likelion.likelioncrud.tag.api.dto.response;

import com.likelion.likelioncrud.tag.domain.Tag;
import lombok.Builder;

@Builder
public record TagInfoResponseDto(
        // Tag가 가지고 있는 정보
        String name
) {
    public static TagInfoResponseDto from(Tag tag) {
        return TagInfoResponseDto.builder()
                .name(tag.getName())
                .build();
    }
}