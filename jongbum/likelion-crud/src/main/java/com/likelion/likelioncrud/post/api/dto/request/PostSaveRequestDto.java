package com.likelion.likelioncrud.post.api.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;

public record PostSaveRequestDto(
        @NotNull(message = "작성자는 필수로 입력해야합니다.") // memberId는 필수
        Long memberId,
        @NotBlank(message = "제목은 필수로 입력해야 합니다.")
        @Size(min = 2, max = 10)    // 최소 2글자, 최대 10글자
        String title,

        @NotBlank(message = "내용은 필수로 입력해야 합니다.")
        @Size(min = 2, max = 10)    // 최소 2글자, 최대 10글자
        String contents,
        
        // 태그 목록을 추가할 리스트
        List<String> tags
) {
}