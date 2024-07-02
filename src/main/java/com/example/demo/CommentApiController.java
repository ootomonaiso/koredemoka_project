package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CommentApiController {

    private final CommentService commentService;

    @Autowired
    public CommentApiController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping("/add-comment")
    public void addComment(@RequestBody Comment comment) {
        commentService.saveComment(comment);
    }

    @PostMapping("/api/delete-comment/{id}")
    public void deleteCommentFromApi(@PathVariable Long id) {
        commentService.deleteComment(id);
    }
}
