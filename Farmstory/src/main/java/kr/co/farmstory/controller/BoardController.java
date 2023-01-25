package kr.co.farmstory.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BoardController {

    @GetMapping("board/list")
    public String list(Model model, String group, String cate){
        if(group.equals("_croptalk") && cate == null){
            cate = "story";
        }else if(group.equals("_community") && cate == null){
            cate = "notice";
        }



        model.addAttribute("group", group);
        model.addAttribute("cate", cate);
        return "board/list";

    }
    @GetMapping("board/write")
    public String write(){
        return "board/write";
    }
}
