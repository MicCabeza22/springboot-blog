package com.codeup.springbootblog;

import com.codeup.springbootblog.daos.UsersRepository;
import com.codeup.springbootblog.models.Post;
import com.codeup.springbootblog.services.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostsController {
    private PostService service;
    private final UsersRepository usersDao;

    public PostsController(PostService service, UsersRepository usersDao) {
        this.service = service;
        this.usersDao = usersDao;
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
}
