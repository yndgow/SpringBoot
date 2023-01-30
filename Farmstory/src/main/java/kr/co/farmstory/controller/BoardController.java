package kr.co.farmstory.controller;

import kr.co.farmstory.dto.ArticleDTO;
import kr.co.farmstory.dto.UserDTO;
import kr.co.farmstory.entity.ArticleEntity;
import kr.co.farmstory.entity.UserEntity;
import kr.co.farmstory.mapper.ArticleMapper;
import kr.co.farmstory.mapper.UserMapper;
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
        int pagingPg = 0;

        pagingPg = (pg == 0) ? 0 : (pg - 1);
        if(pg == 0) pg = 1;
        Page<ArticleEntity> pageList = articleService.boardList(cate, pagingPg);
        PageVO pageVo = articleService.getPageInfo(pageList, pagingPg);

        model.addAttribute("pg", pg);
        model.addAttribute("group", group);
        model.addAttribute("cate", cate);
        model.addAttribute("articles", pageList);
        model.addAttribute("pageVO", pageVo);

        return "board/list";

    }

    @GetMapping("board/view")
    public String view(String no, Model model, String group, String cate, String pg){

        model.addAttribute("pg", pg);
        model.addAttribute("group", group);
        model.addAttribute("cate", cate);
        ArticleDTO dto = ArticleMapper.toDto(articleService.selectArticle(no));
        model.addAttribute("article", dto);
        return "board/view";
    }



    @GetMapping("board/write")

    public String write(){
        return "board/write";
    }
}
