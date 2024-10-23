package com.yth.topndown.post.command.application.service;

import com.yth.topndown.post.command.application.dto.PostDTO;
import com.yth.topndown.post.command.domain.aggregate.Post;
import com.yth.topndown.post.command.domain.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostCommandService {

    private final PostRepository postRepository;

    @Autowired

    public PostCommandService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    // 새로운 게시물 생성
    public PostDTO createPost(PostDTO postDTO) {
        if (postDTO.getUpvotes() == null) {
            postDTO.setUpvotes(0);
        }
        if (postDTO.getDownvotes() == null) {
            postDTO.setDownvotes(0);
        }
        Post post = convertToEntity(postDTO);
        Post savedPost = postRepository.save(post);
        return convertToDTO(savedPost);
    }

    // 게시물 삭제
    public boolean deletePost(Long id) {
        if (postRepository.existsById(id)) {
            postRepository.deleteById(id);
            return true;
        }
        return false;
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

    // PostDTO -> Post 변환
    private Post convertToEntity(PostDTO postDTO) {
        Post post = new Post();
        post.setPostId(postDTO.getId());
        post.setAnonymousUserId(postDTO.getAnonymousUserId());
        post.setTitle(postDTO.getTitle());
        post.setContent(postDTO.getContent());
        post.setCreatedAt(postDTO.getCreatedAt());
        post.setUpvotes(postDTO.getUpvotes());
        post.setDownvotes(postDTO.getDownvotes());
        return post;
    }
}
