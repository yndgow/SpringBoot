package kr.co.farmstory.controller;

import kr.co.farmstory.entity.ArticleEntity;
import kr.co.farmstory.service.ArticleService;
import kr.co.farmstory.vo.PageVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Slf4j
@Controller
public class BoardController {

    private final ArticleService articleService;

    public BoardController(ArticleService articleService){
        this.articleService = articleService;
    }


    @GetMapping("board/list")
    public String list(Model model, String group, String cate, @RequestParam(defaultValue = "0", required = false) int pg){

        if(cate == null){
            switch (group) {
                case "_croptalk" -> cate = "story";
                case "_community" -> cate = "notice";
                case "_event" -> cate = "event";
                case "_market" -> cate = "market";
            }
        }

        pg = (pg == 0) ? 0 : (pg - 1);

        Page<ArticleEntity> pageList = articleService.boardList(cate, pg);
        PageVO pageVo = articleService.getPageInfo(pageList, pg);

        model.addAttribute("pg", pg);
        model.addAttribute("group", group);
        model.addAttribute("cate", cate);
        model.addAttribute("articles", pageList);
        model.addAttribute("pageVO", pageVo);

        return "board/list";

    }
    @GetMapping("board/write")
    public String write(){
        return "board/write";
    }
}
