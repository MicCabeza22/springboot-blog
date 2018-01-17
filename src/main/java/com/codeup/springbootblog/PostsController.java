package com.codeup.springbootblog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostsController {
    @GetMapping("/posts")
    @ResponseBody
    public String postIndexPage() {
        return "This is the \"posts\" index page!";
    }

    @RequestMapping(path = "/posts/{id}", method = RequestMethod.GET)
    @ResponseBody
    public String viewIndividualPost(@PathVariable int id) {
        return "This is an individual post for ID " + id + ".";
    }

    @GetMapping("/posts/create")
    @ResponseBody
    public String viewCreatePostForm() {
        return "This page will contain a form for creating a post.";
    }

    @PostMapping("/posts/create")
    @ResponseBody
    public String createNewPost() {
        return "This page will show a new post.";
    }
}
