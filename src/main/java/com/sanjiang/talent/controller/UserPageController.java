package com.sanjiang.talent.controller;

import com.sanjiang.talent.service.UserService;
import com.sanjiang.talent.vo.LoginUserDto;
import com.sanjiang.talent.vo.MenuDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.List;


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
    public String enterIndex(@ModelAttribute("loginUserDto") LoginUserDto loginUserDto, ModelMap modelMap) {
        String loginUserId = loginUserDto.getLoginUserId();
        List<MenuDto> menuByLoginuserId = userService.getMenuByLoginuserId(loginUserId);
        modelMap.addAttribute("menu", menuByLoginuserId);
        return "index";
    }
}
