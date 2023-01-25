package kr.co.farmstory.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @GetMapping("user/register")
    public String userRegister(){
        return "user/register";
    }

    @GetMapping("user/login")
    public String userLogin(){
        return "user/login";
    }

    @GetMapping("user/terms")
    public String userTerms(){
        return "user/terms";
    }

}
