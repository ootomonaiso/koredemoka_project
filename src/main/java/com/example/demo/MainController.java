package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    private final CommentService commentService;

    @Autowired
    public MainController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping("/") // ホーム
    public String mainGet(Model model) {
        return "index";
    }

    @GetMapping("/chat") // チャットページ
    public String chatGet(Model model) {
        List<Comment> comments = commentService.getAllComments();
        model.addAttribute("comments", comments);
        return "chat";
    }

    @PostMapping("/add_comment")
    public String addComment(@RequestParam String nickname, @RequestParam String text) {
        Comment comment = new Comment();
        comment.setNickname(nickname);
        comment.setText(text);
        commentService.saveComment(comment);
        return "redirect:/chat";
    }

    @PostMapping("/delete_comment")
    public String deleteComment(@RequestParam Long id) {
        commentService.deleteComment(id);
        return "redirect:/chat";
    }

    @GetMapping("/stem_access")
    public String stem_accessGet(Model model) {
        return "stem_access";
    }

    @GetMapping("/stem_award")
    public String stem_awardGet(Model model) {
        return "stem_award";
    }

    @GetMapping("/stem_contact")
    public String stem_contactGet(Model model) {
        return "stem_contact";
    }

    @GetMapping("/stem_gaiyou")
    public String stem_gaiyouGet(Model model) {
        return "stem_gaiyou";
    }

    @GetMapping("/stem_history")
    public String stem_historyGet(Model model) {
        return "stem_history";
    }

    @GetMapping("/stem_housin")
    public String stem_housinGet(Model model) {
        return "stem_housin";
    }

    @GetMapping("/stem_join")
    public String stem_joinGet(Model model) {
        return "stem_join";
    }

    @GetMapping("/stem_member")
    public String stem_membrGet(Model model) {
        return "stem_member";
    }

    @GetMapping("/stem_question")
    public String stem_questionGet(Model model) {
        return "stem_question";
    }

    @GetMapping("/stem_school")
    public String stem_schoolGet(Model model) {
        return "stem_school";
    }
}
