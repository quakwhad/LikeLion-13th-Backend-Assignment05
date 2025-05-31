package com.likelion.likelioncrud.common.error;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum SuccessCode {

    // 200 OK
    GET_SUCCESS(HttpStatus.OK, "성공적으로 조회했습니다."),
    MEMBER_UPDATE_SUCCESS(HttpStatus.OK, "사용자가 성공적으로 수정됐습니다."),
    POST_UPDATE_SUCCESS(HttpStatus.OK, "게시물이 성공적으로 수정됐습니다."),
    TAG_UPDATE_SUCCESS(HttpStatus.OK, "태그가 성공적으로 수정됐습니다."),
    
    MEMBER_DELETE_SUCCESS(HttpStatus.OK, "사용자가 성공적으로 삭제됐습니다."),
    POST_DELETE_SUCCESS(HttpStatus.OK, "게시물이 성공적으로 삭제됐습니다."),
    TAG_DELETE_SUCCESS(HttpStatus.OK, "태그가 성공적으로 삭제됐습니다."),

    // 201 CREATE
    MEMBER_SAVE_SUCCESS(HttpStatus.CREATED, "사용자가 성공적으로 생성됐습니다."),
    POST_SAVE_SUCCESS(HttpStatus.CREATED, "게시물이 성공적으로 생성됐습니다."),
    TAG_SAVE_SUCCESS(HttpStatus.CREATED, "태그가 성공적으로 생성됐습니다.");

    private final HttpStatus httpStatus;
    private final String message;

    public int getHttpStatusCode() {
        return httpStatus.value();
    }
}
