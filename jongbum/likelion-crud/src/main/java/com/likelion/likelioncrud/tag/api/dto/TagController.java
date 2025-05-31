package com.likelion.likelioncrud.tag.api.dto;

import com.likelion.likelioncrud.common.error.SuccessCode;
import com.likelion.likelioncrud.common.template.ApiResTemplate;
import com.likelion.likelioncrud.tag.api.dto.request.TagSaveRequestDto;
import com.likelion.likelioncrud.tag.api.dto.request.TagUpdateRequestDto;
import com.likelion.likelioncrud.tag.api.dto.response.TagInfoResponseDto;
import com.likelion.likelioncrud.tag.api.dto.response.TagListResponseDto;
import com.likelion.likelioncrud.tag.application.TagService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/tag")
public class TagController {
    private final TagService tagService;

    // 태그 저장
    @PostMapping("/save")
    public ApiResTemplate<String> tagSave(@RequestBody TagSaveRequestDto tagSaveRequestDto) {
        tagService.tagSave(tagSaveRequestDto);
        return ApiResTemplate.successWithNoContent(SuccessCode.TAG_SAVE_SUCCESS);
    }

    // 태그 전체 조회
    @GetMapping("/all")
    public ApiResTemplate<TagListResponseDto> tagFindAll() {
        TagListResponseDto tagListResponseDto = tagService.tagFindAll();
        return ApiResTemplate.successResponse(SuccessCode.GET_SUCCESS, tagListResponseDto);
    }

    // 태그 id를 통한 단건 조회
    @GetMapping("/{tagId}")
    public ApiResTemplate<TagInfoResponseDto> tagFindOne(@PathVariable("tagId") Long tagId) {
        TagInfoResponseDto tagInfoResponseDto = tagService.tagFindOne(tagId);
        return ApiResTemplate.successResponse(SuccessCode.GET_SUCCESS, tagInfoResponseDto);
    }

    // 태그 수정
    @PatchMapping("/{tagId}")
    public ApiResTemplate<String> tagUpdate(
            @PathVariable("tagId") Long tagId,
            @RequestBody @Valid TagUpdateRequestDto tagUpdateRequestDto) {
        tagService.tagUpdate(tagId, tagUpdateRequestDto);
        return ApiResTemplate.successWithNoContent(SuccessCode.TAG_UPDATE_SUCCESS);
    }

    // 태그 id를 통한 태그 삭제
    @DeleteMapping("/{tagId}")
    public ApiResTemplate<String> tagDelete(
            @PathVariable("tagId") Long tagId) {
        tagService.tagDelete(tagId);
        return ApiResTemplate.successWithNoContent(SuccessCode.TAG_DELETE_SUCCESS);
    }
}
