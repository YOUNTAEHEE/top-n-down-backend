package com.yth.topndown.post.command.domain.aggregate;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId;

    @Column(nullable = false)
    private Integer anonymousUserId;

    @Column(nullable = false, length = 255)
    private String title;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String content;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(nullable = false)
    private Integer upvotes = 0;  // upvotes가 null이 될 수 없도록 설정

    @Column(nullable = false)
    private Integer downvotes = 0;  // downvotes가 null이 될 수 없도록 설정

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
        if (this.upvotes == null) {
            this.upvotes = 0;
        }
        if (this.downvotes == null) {
            this.downvotes = 0;
        }
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public Integer getAnonymousUserId() {
        return anonymousUserId;
    }

    public void setAnonymousUserId(Integer anonymousUserId) {
        this.anonymousUserId = anonymousUserId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Integer getUpvotes() {
        return upvotes;
    }

    public void setUpvotes(Integer upvotes) {
        this.upvotes = upvotes;
    }

    public Integer getDownvotes() {
        return downvotes;
    }

    public void setDownvotes(Integer downvotes) {
        this.downvotes = downvotes;
    }
}
