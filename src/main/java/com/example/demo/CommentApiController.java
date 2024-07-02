package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping("/past-comments")
    public ResponseEntity<List<Comment>> getPastComments() {
        List<Comment> pastComments = commentService.getAllComments(); // CommentServiceで過去のコメントを取得するメソッド名に合わせる必要があります
        return ResponseEntity.ok().body(pastComments);
    }
}
