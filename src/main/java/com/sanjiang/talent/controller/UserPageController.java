package com.sanjiang.talent.controller;

import com.sanjiang.talent.service.UserService;
import com.sanjiang.talent.vo.LoginUserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
@SessionAttributes(value = {"loginUserDto"})
public class UserPageController {

    @Autowired
    private UserService userService;

    @GetMapping("login")
    public String enterPage() {
        return "login";
    }

    @GetMapping("index")
    public String enterIndex(@ModelAttribute("loginUserDto") LoginUserDto loginUserDto) {
        return "index";
    }
}
