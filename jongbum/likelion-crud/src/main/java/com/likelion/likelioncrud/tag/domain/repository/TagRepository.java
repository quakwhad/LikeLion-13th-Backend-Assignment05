package com.likelion.likelioncrud.tag.domain.repository;

import com.likelion.likelioncrud.member.domain.Member;
import com.likelion.likelioncrud.post.domain.Post;
import com.likelion.likelioncrud.tag.domain.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface TagRepository extends JpaRepository<Tag, Long> {
    // 태그 이름을 통해 Tag 엔티티를 조회하는 메서드 추가
    Optional<Tag> findByName(String name);

    // 모든 태그를 조회할 때, PostTag 컬렉션을 FETCH JOIN으로 함께 가져옵니다.
    @Query("SELECT t FROM Tag t LEFT JOIN FETCH t.postTags pt") // LEFT JOIN FETCH 사용
    List<Tag> findAllWithPostTags();
}
