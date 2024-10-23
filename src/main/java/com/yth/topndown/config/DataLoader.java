package com.yth.topndown.config;

import com.yth.topndown.post.command.domain.aggregate.Post;
import com.yth.topndown.post.command.domain.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class DataLoader implements CommandLineRunner {

    private final PostRepository postRepository;

    @Autowired
    public DataLoader(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // 더미 데이터 삽입

        Post post1 = new Post();
        post1.setAnonymousUserId(1);
        post1.setTitle("First Anonymous Post");
        post1.setContent("This is the content of the first post.");
        post1.setCreatedAt(LocalDateTime.now());
        post1.setUpvotes(10);
        post1.setDownvotes(2);
        postRepository.save(post1);

        Post post2 = new Post();
        post2.setAnonymousUserId(2);
        post2.setTitle("Second Anonymous Post");
        post2.setContent("This is the content of the second post.");
        post2.setCreatedAt(LocalDateTime.now());
        post2.setUpvotes(5);
        post2.setDownvotes(1);
        postRepository.save(post2);

        Post post3 = new Post();
        post3.setAnonymousUserId(3);
        post3.setTitle("Third Anonymous Post");
        post3.setContent("This is the content of the third post.");
        post3.setCreatedAt(LocalDateTime.now());
        post3.setUpvotes(7);
        post3.setDownvotes(0);
        postRepository.save(post3);

        // 더 필요한 경우 계속해서 추가 가능
    }
}
