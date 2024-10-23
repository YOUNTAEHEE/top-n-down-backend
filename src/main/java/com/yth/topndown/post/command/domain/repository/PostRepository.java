package com.yth.topndown.post.command.domain.repository;

import com.yth.topndown.post.command.domain.aggregate.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    // 특정 익명 사용자의 모든 게시물 찾기 (페이지네이션 포함)
    default Page<Post> findByAnonymousUserIdOrdered(Integer anonymousUserId, Pageable pageable) {
        Pageable sortedByCreatedAtDesc = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), Sort.by("createdAt").descending());
        return findByAnonymousUserId(anonymousUserId, sortedByCreatedAtDesc);
    }

    // 제목으로 게시물 검색 (페이지네이션 포함)
    default Page<Post> findByTitleContainingOrdered(String title, Pageable pageable) {
        Pageable sortedByCreatedAtDesc = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), Sort.by("createdAt").descending());
        return findByTitleContaining(title, sortedByCreatedAtDesc);
    }

    // 특정 날짜 이후에 작성된 게시물 찾기 (페이지네이션 포함)
    default Page<Post> findByCreatedAtAfterOrdered(LocalDateTime date, Pageable pageable) {
        Pageable sortedByCreatedAtDesc = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), Sort.by("createdAt").descending());
        return findByCreatedAtAfter(date, sortedByCreatedAtDesc);
    }

    // Upvotes가 특정 값 이상인 게시물 찾기 (페이지네이션 포함)
    default Page<Post> findByUpvotesGreaterThanEqualOrdered(Integer upvotes, Pageable pageable) {
        Pageable sortedByCreatedAtDesc = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), Sort.by("createdAt").descending());
        return findByUpvotesGreaterThanEqual(upvotes, sortedByCreatedAtDesc);
    }

    // 기본 메서드들
    Page<Post> findByAnonymousUserId(Integer anonymousUserId, Pageable pageable);
    Page<Post> findByTitleContaining(String title, Pageable pageable);
    Page<Post> findByCreatedAtAfter(LocalDateTime date, Pageable pageable);
    Page<Post> findByUpvotesGreaterThanEqual(Integer upvotes, Pageable pageable);
}
