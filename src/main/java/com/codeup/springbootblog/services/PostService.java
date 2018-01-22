package com.codeup.springbootblog.services;

import com.codeup.springbootblog.models.Post;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {
    private List<Post> posts;

    public PostService() {
        posts = new ArrayList<>();
        createPosts();
    }

    public List<Post> findAll() {
        return posts;
    }

    public void save(Post post) {
        post.setId(posts.size() + 1);
        posts.add(post);
    }

    public Post findOne(int id) {
        return posts.get(id - 1);
    }

    private void createPosts() {
        save(new Post("Post 1", "This is the first post."));
        save(new Post("Post 2", "This is the second post."));
        save(new Post("Post 3", "This is the third post."));
    }

    public void edit(Post post) {
        posts.set(post.getId() - 1, post);
    }
}
