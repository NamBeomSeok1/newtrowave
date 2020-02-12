package com.kostars.newtroshop.web;

import com.kostars.newtroshop.config.auth.LoginUser;
import com.kostars.newtroshop.config.auth.dto.SessionUser;
import com.kostars.newtroshop.service.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;

    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser user) {
        model.addAttribute("posts", postsService.findAllDesc());
        if (user != null) {
            model.addAttribute("userName", user.getName());
        }
        return "index";
    }

    @GetMapping("/loginpage")
    public String loginpage() {

        return "loginpage";
    }
    @GetMapping("/order")
    public String order(){

        return "order";
    }



}
