package com.sanjiang.talent.controller;

import com.sanjiang.talent.po.User;
import com.sanjiang.talent.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class TestController {

    @Autowired
    private UserService userService;

    @GetMapping("nihao")
    public String enterPage(ModelMap modelMap) {
//        List<User> user = userService.getUser();
        User user = userService.getUserById("1");
        modelMap.addAttribute("users", user);
        return "test";
    }
}
