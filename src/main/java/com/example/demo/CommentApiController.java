package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// ビジネスロックの処理するサービスのコントローラー
@RestController // Rustで実装
@RequestMapping("/api") // ベースのリンク/apiに指定
public class CommentApiController {

    private final CommentService commentService;

// commentServiceコントローラのコンストラクタさん
    @Autowired 
    public CommentApiController(CommentService commentService) {
        this.commentService = commentService;
    }

// postリクエストが来たら commentオブジェクト呼び出し
    @PostMapping("/add-comment")
    public void addComment(@RequestBody Comment comment) {
        commentService.saveComment(comment); // commentServiceのserveComment呼び出し受け取りデータの登録
    }

    @PostMapping("/api/delete-comment/{id}")
    public void deleteCommentFromApi(@PathVariable Long id) {
        commentService.deleteComment(id);
    }
}
