package com.yth.topndown.post.query.application.service;

import com.yth.topndown.post.command.application.dto.PostDTO;
import com.yth.topndown.post.command.domain.aggregate.Post;
import com.yth.topndown.post.command.domain.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PostQueryService {

    private final PostRepository postRepository;

    @Autowired
    public PostQueryService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    // 모든 게시물 조회 (페이지네이션 포함)
    public Page<PostDTO> getAllPosts(Pageable pageable) {
        return postRepository.findAll(pageable)
                .map(this::convertToDTO);
    }

    // 특정 게시물 조회
    public Optional<PostDTO> getPostById(Long id) {
        return postRepository.findById(id)
                .map(this::convertToDTO);
    }

    // 특정 사용자에 대한 게시물 조회 (페이지네이션 포함)
    public Page<PostDTO> getPostsByUserId(Integer anonymousUserId, Pageable pageable) {
        return postRepository.findByAnonymousUserId(anonymousUserId, pageable)
                .map(this::convertToDTO);
    }

    // 제목을 포함한 게시물 검색 (페이지네이션 포함)
    public Page<PostDTO> searchPostsByTitle(String title, Pageable pageable) {
        return postRepository.findByTitleContaining(title, pageable)
                .map(this::convertToDTO);
    }

    // Upvotes가 특정 수 이상인 게시물 조회 (페이지네이션 포함)
    public Page<PostDTO> getPopularPosts(Integer upvotes, Pageable pageable) {
        return postRepository.findByUpvotesGreaterThanEqual(upvotes, pageable)
                .map(this::convertToDTO);
    }

    // Post -> PostDTO 변환
    private PostDTO convertToDTO(Post post) {
        return new PostDTO(
                post.getPostId(),
                post.getAnonymousUserId(),
                post.getTitle(),
                post.getContent(),
                post.getCreatedAt(),
                post.getUpvotes(),
                post.getDownvotes()
        );
    }
}
