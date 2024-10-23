package com.yth.topndown.post.query.application.controller;

import com.yth.topndown.post.command.application.dto.PostDTO;
import com.yth.topndown.post.query.application.service.PostQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/posts")
public class PostQueryController {

    private final PostQueryService postService;

    @Autowired
    public PostQueryController(PostQueryService postService) {
        this.postService = postService;
    }

    // 모든 게시물 조회 (페이지네이션 포함)
    @GetMapping
    public ResponseEntity<Page<PostDTO>> getAllPosts(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<PostDTO> posts = postService.getAllPosts(pageable);
        return ResponseEntity.ok(posts);
    }

    // 특정 게시물 조회
    @GetMapping("/{id}")
    public ResponseEntity<PostDTO> getPostById(@PathVariable Long id) {
        Optional<PostDTO> postDTO = postService.getPostById(id);
        return postDTO.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    // 특정 사용자에 대한 게시물 조회 (페이지네이션 포함)
    @GetMapping("/user/{anonymousUserId}")
    public ResponseEntity<Page<PostDTO>> getPostsByUserId(
            @PathVariable Integer anonymousUserId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<PostDTO> posts = postService.getPostsByUserId(anonymousUserId, pageable);
        return ResponseEntity.ok(posts);
    }

    // 제목을 포함한 게시물 검색 (페이지네이션 포함)
    @GetMapping("/search")
    public ResponseEntity<Page<PostDTO>> searchPostsByTitle(
            @RequestParam String title,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<PostDTO> posts = postService.searchPostsByTitle(title, pageable);
        return ResponseEntity.ok(posts);
    }

    // Upvotes가 특정 수 이상인 게시물 조회 (페이지네이션 포함)
    @GetMapping("/popular")
    public ResponseEntity<Page<PostDTO>> getPopularPosts(
            @RequestParam Integer upvotes,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<PostDTO> posts = postService.getPopularPosts(upvotes, pageable);
        return ResponseEntity.ok(posts);
    }
}
