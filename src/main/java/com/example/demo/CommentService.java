package com.example.demo;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

    private final CommentRepository commentRepository;

    @Autowired
    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public List<Comment> getAllComments() {
        return commentRepository.findAll();
    }

    public void saveComment(Comment comment) {
        comment.setTimestamp(LocalDateTime.now());
        commentRepository.save(comment);
    }

    public void deleteOldComments() {
        LocalDateTime oneMonthAgo = LocalDateTime.now().minusMonths(1);
        List<Comment> oldComments = commentRepository.findByTimestampAfter(oneMonthAgo);
        commentRepository.deleteAll(oldComments);
    }

    public void deleteComment(Long id) {
        commentRepository.deleteById(id);
    }
}
