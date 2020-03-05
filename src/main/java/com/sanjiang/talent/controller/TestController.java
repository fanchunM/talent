package com.sanjiang.talent.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

    @GetMapping("nihao")
    public String enterPage() {
        return "test";
    }
}
