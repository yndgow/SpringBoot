package kr.co.farmstory.controller;

import kr.co.farmstory.entity.ArticleEntity;
import kr.co.farmstory.service.ArticleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Slf4j
@Controller
public class BoardController {

    private final ArticleService articleService;

    public BoardController(ArticleService articleService){
        this.articleService = articleService;
    }


    @GetMapping("board/list")
    public String list(Model model, String group, String cate){

        if(cate == null){
            switch (group) {
                case "_croptalk" -> cate = "story";
                case "_community" -> cate = "notice";
                case "_event" -> cate = "event";
                case "_market" -> cate = "market";
            }
        }
        List<ArticleEntity> articles = articleService.boardList(cate, Pageable.ofSize(10));

        log.info("getPageNum:" + Pageable.ofSize(10).getPageNumber());

        model.addAttribute("group", group);
        model.addAttribute("articles",articleService.boardList(cate, Pageable.ofSize(10)));
        return "board/list";

    }
    @GetMapping("board/write")
    public String write(){
        return "board/write";
    }
}
