package kr.co.farmstory.controller;

import kr.co.farmstory.service.TermsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
@Slf4j
@Controller
public class UserController {

    @Autowired
    private TermsService termsService;


    @GetMapping("user/register")
    public String userRegister(){
        return "user/register";
    }

    @GetMapping("user/login")
    public String userLogin(){
        return "user/login";
    }

    @GetMapping("user/terms")
    public String userTerms(Model m){
        m.addAttribute("terms", termsService.selectTerms());
        return "user/terms";
    }

}
