package com.codeup.springbootblog.controllers;

import com.codeup.springbootblog.repositories.UsersRepository;
import com.codeup.springbootblog.models.Post;
import com.codeup.springbootblog.models.User;
import com.codeup.springbootblog.services.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostsController {
    private final PostService service;
    private final UsersRepository usersRepository;

    public PostsController(PostService service, UsersRepository usersRepository) {
        this.service = service;
        this.usersRepository = usersRepository;
    }

    @GetMapping("/posts")
    public String postIndexPage(Model model) {
        Iterable<Post> posts = service.findAll();
        model.addAttribute("posts", posts);
        return "posts/index";
    }

    @RequestMapping(path = "/posts/{id}", method = RequestMethod.GET)
    public String viewIndividualPost(@PathVariable long id, Model model) {
        Post post = service.findOne(id);
        User user = post.getUser();
        model.addAttribute("post", post);
        model.addAttribute("user", user);
        return "posts/show";
    }

    @GetMapping("/posts/create")
    public String viewCreatePostForm(Model model) {
        model.addAttribute("post", new Post());
        return "posts/create";
    }

    @PostMapping("/posts/create")
    public String createNewPost(@ModelAttribute Post post) {
        User user = usersRepository.findOne(2L);
        post = new Post(post.getTitle(), post.getBody(), user);
        service.save(post);
        return "redirect:/posts";
    }

    @GetMapping("/posts/{id}/edit")
    public String viewEditPostForm(@PathVariable long id, Model model) {
        Post post = service.findOne(id);
        model.addAttribute("post", post);
        return "posts/edit";
    }

    @PostMapping("/posts/{id}/edit")
    public String editPost(@PathVariable long id, @ModelAttribute Post post) {
        post.setId(id);
        service.save(post);
        return "redirect:/posts";
    }

    @PostMapping("/posts/{id}/delete")
    public String deletePost(@PathVariable long id) {
        service.delete(id);
        return "redirect:/posts";
    }
}
