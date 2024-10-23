package com.yth.topndown.post.command.application.controller;

import com.yth.topndown.post.command.application.dto.PostDTO;
import com.yth.topndown.post.command.application.service.PostCommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/posts")
public class PostCommandController {

    private final PostCommandService postService;

    @Autowired
    public PostCommandController(PostCommandService postService) {
        this.postService = postService;
    }

    // 새로운 게시물 생성
    @PostMapping
    public ResponseEntity<PostDTO> createPost(@RequestBody PostDTO postDTO) {
        try {
            PostDTO savedPostDTO = postService.createPost(postDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedPostDTO);
        } catch (Exception e) {
            // Log the exception and return a 500 error
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }


    // 게시물 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePost(@PathVariable Long id) {
        boolean isDeleted = postService.deletePost(id);
        return isDeleted ?
                ResponseEntity.status(HttpStatus.NO_CONTENT).build() :
                ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

}
