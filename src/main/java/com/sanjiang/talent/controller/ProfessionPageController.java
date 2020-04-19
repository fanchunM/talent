package com.sanjiang.talent.controller;

import com.sanjiang.talent.vo.LoginUserDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@Slf4j
@SessionAttributes(value = {"loginUserDto"})
public class ProfessionPageController {

    @GetMapping("profession_manage")
    public String enterProfessionManagePage(@ModelAttribute("loginUserDto") LoginUserDto loginUserDto) {
        log.info("ENTER PROFESSION MANAGE PAGE");
        return "profession/professionManage";
    }

    @GetMapping("profession_course_manage")
    public String enterProfessionCourseManagePage(@ModelAttribute("loginUserDto") LoginUserDto loginUserDto) {
        log.info("ENTER Profession Course MANAGE PAGE");
        return "profession/professionCourseManage";
    }
}
