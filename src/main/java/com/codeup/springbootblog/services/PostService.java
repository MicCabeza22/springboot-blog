package com.codeup.springbootblog.services;

import com.codeup.springbootblog.repositories.PostsRepository;
import com.codeup.springbootblog.models.Post;
import org.springframework.stereotype.Service;

@Service
public class PostService {
    private final PostsRepository postsDao;

    public PostService(PostsRepository postsDao) {
        this.postsDao = postsDao;
    }

    public Iterable<Post> findAll() {
        return postsDao.findAll();
    }

    public Post findOne(long id) {
        return postsDao.findOne(id);
    }

    public void save(Post post) {
        postsDao.save(post);
    }

    public void delete(long id) {
        postsDao.delete(id);
    }
}
