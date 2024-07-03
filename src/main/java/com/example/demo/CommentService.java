package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service //サービスレイヤー spring管轄 モデル部分
public class CommentService {

    private final CommentRepository commentRepository; 

// commentrepositoryの自動注入
    @Autowired
    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

// コメント全取得
    public List<Comment> getAllComments() {
        return commentRepository.findAll();
    }

// コメント保存
    public void saveComment(Comment comment) {
        commentRepository.save(comment);
    }

    public void deleteComment(Long id) {
        commentRepository.deleteById(id);
    }
}
