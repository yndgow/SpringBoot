package kr.co.iBoard.controller;

import kr.co.iBoard.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ArticleController {

    @Autowired
    private ArticleService service;

    @GetMapping("/article")
    public String list(Model model){
        model.addAttribute("articles", service.selectArticles());

        return "list";
    }

}
