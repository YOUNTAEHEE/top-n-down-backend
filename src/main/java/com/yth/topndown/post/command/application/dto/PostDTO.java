package com.yth.topndown.post.command.application.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PostDTO {

    private Long id; // postId를 id로 매핑
    private Integer anonymousUserId;
    private String title;
    private String content;
    private LocalDateTime createdAt;
    private Integer upvotes = 0;  // 기본값 설정
    private Integer downvotes = 0;  // 기본값 설정

    public PostDTO(Long id, Integer anonymousUserId, String title, String content, LocalDateTime createdAt, Integer upvotes, Integer downvotes) {
        this.id = id;
        this.anonymousUserId = anonymousUserId;
        this.title = title;
        this.content = content;
        this.createdAt = createdAt;
        this.upvotes = upvotes;
        this.downvotes = downvotes;
    }
}
