package com.example.demo;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public MainController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @GetMapping("/") // ホーム
    public String mainGet(Model model) {
        return "index";
    }

    @GetMapping("/show_result")
    public String show_resultGet(Model model) {
        try {
            List<Map<String, Object>> searchResult = jdbcTemplate.queryForList("SELECT * FROM log");
            model.addAttribute("searchResult", searchResult);
        } catch (Exception e) {
            model.addAttribute("error", "データの取得に失敗しました: " + e.getMessage());
        }
        return "show_result";
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
