package kr.co.farmstory.controller;

import kr.co.farmstory.configure.MyUserDetails;
import kr.co.farmstory.dto.UserDTO;
import kr.co.farmstory.service.TermsService;
import kr.co.farmstory.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Slf4j
@Controller
public class UserController {
    private final UserService userService;

    private final TermsService termsService;

    public UserController(TermsService termsService,
                          UserService userService) {
        this.termsService = termsService;
        this.userService = userService;
    }

    @GetMapping("user/register")
    public String userRegister(){
        return "user/register";
    }

    @GetMapping("user/login")
    public String userLogin(@AuthenticationPrincipal MyUserDetails user, HttpServletRequest req){

        if(user == null){
            HttpSession session = req.getSession();
            session.invalidate();
        }
        return "user/login";
    }

    @GetMapping("user/terms")
    public String userTerms(Model m){
        m.addAttribute("terms", termsService.selectTerms());
        return "user/terms";
    }

    @PostMapping("user/register")
    public String userRegister(UserDTO.SignUpReq user){
        userService.insertUser(user);
        return "redirect:/user/login";
    }


}
