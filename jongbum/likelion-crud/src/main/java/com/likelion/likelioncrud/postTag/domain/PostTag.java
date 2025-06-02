package com.likelion.likelioncrud.postTag.domain;

import com.likelion.likelioncrud.post.domain.Post;
import com.likelion.likelioncrud.tag.domain.Tag;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PostTag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "postTag_id")
    private Long postTagId;

    // 여러 Post는 하나의 Post에 연결되어야 한다. 지연로딩을 설정해야한다.
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id", nullable = false)
    private Post post;

    // 여러 PostTag는 하나의 tag에 연결되어야 한다. 지연로딩을 설정해야한다.
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tag_id", nullable = false)
    private Tag tag;

    @Builder
    public PostTag(Post post, Tag tag) {
        this.post = post;
        this.tag = tag;
    }
}
