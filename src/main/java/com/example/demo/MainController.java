package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {

    private final CommentService commentService;

    @Autowired
    public MainController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping("/") // ホーム
    public String mainGet() {
        return "index";
    }

    @GetMapping("/chat") // チャットページ
    public String chatGet(Model model) {
        List<Comment> comments = commentService.getAllComments();
        model.addAttribute("comments", comments);
        return "chat";
    }

    @GetMapping("/api/past-comments") // 過去のコメント取得
    @ResponseBody
    public List<Comment> getPastComments() {
        return commentService.getAllComments();
    }

    // /api/add-comment のエンドポイントを削除競合しちゃった
    // @PostMapping("/api/add-comment")
    // @ResponseBody
    // public void addComment(@RequestBody Comment comment) {
    //     commentService.saveComment(comment);
    // }

    @PostMapping("/api/delete-comment/{id}") // コメント削除
    @ResponseBody
    public void deleteComment(@PathVariable Long id) {
        commentService.deleteComment(id);
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

    @GetMapping("/stem_hoshin")
    public String stem_hoshinGet(Model model) {
        return "stem_hoshin";
    }

    @GetMapping("/stem_join")
    public String stem_joinGet(Model model) {
        return "stem_join";
    }

    @GetMapping("/stem_member")
    public String stem_memberGet(Model model) {
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
    
    @GetMapping("/showchat")
    public String showchatGet(Model model) {
        return "chat";
    }
    
    @GetMapping("/footer")
    public String footerGet(Model model) {
        return "footer";
    }
    
    @GetMapping("/header")
    public String headerGet(Model model) {
        return "header";
    }
}
