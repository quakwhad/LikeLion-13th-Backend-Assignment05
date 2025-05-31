package com.likelion.likelioncrud.member.api.dto.request;

public record MemberUpdateRequestDto(
        // 업데이트할 변수만 입력
        String name,
        int age
) {
}
