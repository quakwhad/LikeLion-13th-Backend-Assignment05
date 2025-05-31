package com.likelion.likelioncrud.tag.api.dto.request;

import jakarta.validation.constraints.NotBlank;

public record TagSaveRequestDto(
        // 저장할 변수
        @NotBlank(message = "태그 이름은 필수로 입력해야 합니다.")
        String name
) {
}
