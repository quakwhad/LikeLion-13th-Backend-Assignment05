package com.likelion.likelioncrud.tag.application;

import com.likelion.likelioncrud.common.error.ErrorCode;
import com.likelion.likelioncrud.common.exception.BusinessException;
import com.likelion.likelioncrud.post.domain.repository.PostRepository;
import com.likelion.likelioncrud.tag.api.dto.request.TagSaveRequestDto;
import com.likelion.likelioncrud.tag.api.dto.request.TagUpdateRequestDto;
import com.likelion.likelioncrud.tag.api.dto.response.TagInfoResponseDto;
import com.likelion.likelioncrud.tag.api.dto.response.TagListResponseDto;
import com.likelion.likelioncrud.tag.domain.Tag;
import com.likelion.likelioncrud.tag.domain.repository.TagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class TagService {
    private final TagRepository tagRepository;
    private final PostRepository postRepository;

    // 태그 저장
    @Transactional
    public void tagSave(TagSaveRequestDto tagSaveRequestDto) {
        Tag tag = Tag.builder()
                .name(tagSaveRequestDto.name())
                .build();
        tagRepository.save(tag);
    }

    // tag 전체 조회
    // post에 넣은 tag와 따로 저장한 tag가 함께 출력 <= ??
    @Transactional
    public TagListResponseDto tagFindAll() {
        List<Tag> tags = tagRepository.findAllWithPostTags();
        List<TagInfoResponseDto> tagInfoResponseDtoList = tags.stream()
                .map(TagInfoResponseDto::from)
                .toList();
        return TagListResponseDto.from(tagInfoResponseDtoList);
    }

    // 태그 id를 통한 단건 조회
    @Transactional
    public TagInfoResponseDto tagFindOne(Long tagId) {
        Tag tag = tagRepository
                .findById(tagId)
                .orElseThrow(
                        // 찾는 tagId가 없다면 출력할 오류
                        () -> new BusinessException(ErrorCode.TAG_NOT_FOUND_EXCEPTION,
                        ErrorCode.TAG_NOT_FOUND_EXCEPTION.getMessage() + tagId)
                );
        return TagInfoResponseDto.from(tag);
    }

    // 태그 수정
    @Transactional
    public void tagUpdate(Long tagId, TagUpdateRequestDto tagUpdateRequestDto) {
        Tag tag = tagRepository.findById(tagId).orElseThrow(IllegalArgumentException::new);
        tag.update(tagUpdateRequestDto);
    }

    // 태그 삭제
    @Transactional
    public void tagDelete(Long tagId) {
        Tag tag = tagRepository.findById(tagId).orElseThrow(IllegalArgumentException::new);
        tagRepository.delete(tag);
    }
}
