package kr.co.farmstory.controller;

import kr.co.farmstory.service.TermsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
@Slf4j
@Controller
public class UserController {

    private final TermsService termsService;

    public UserController(TermsService termsService) {
        this.termsService = termsService;
    }

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
