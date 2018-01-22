package com.codeup.springbootblog;

import com.codeup.springbootblog.models.Post;
import com.codeup.springbootblog.services.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PostsController {
    private PostService service;

    public PostsController(PostService service) {
        this.service = service;
    }

    @GetMapping("/posts")
    public String postIndexPage(Model model) {
        List<Post> posts = service.findAll();

        model.addAttribute("posts", posts);

        return "posts/index";
    }

    @RequestMapping(path = "/posts/{id}", method = RequestMethod.GET)
    public String viewIndividualPost(@PathVariable int id, Model model) {
        Post post = service.findOne(id);

        model.addAttribute("post", post);

        return "posts/show";
    }

    @GetMapping("/posts/create")
    public String viewCreatePostForm(Model model) {
        model.addAttribute("post", new Post());

        return "posts/create";
    }

    @PostMapping("/posts/create")
    public String createNewPost(@ModelAttribute Post post) {
        service.save(post);

        return "redirect:/posts";
    }

    @GetMapping("/posts/{id}/edit")
    public String viewEditPostForm(@PathVariable int id, Model model) {
        Post post = service.findOne(id);
        model.addAttribute("post", post);
        return "posts/edit";
    }

    @PostMapping("/posts/edit")
    public String editPost(@ModelAttribute Post post) {
        service.edit(post);
        return "redirect:/posts";
    }
}
