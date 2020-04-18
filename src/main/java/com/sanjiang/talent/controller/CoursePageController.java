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
public class CoursePageController {


    @GetMapping("course_manage")
    public String enterCourseManagePage(@ModelAttribute("loginUserDto") LoginUserDto loginUserDto) {
        log.info("ENTER COURSE MANAGE PAGE");
        return "courses/courseManage";
    }

    @GetMapping("course_units_manage")
    public String enterCourseUnitsManagePage(@ModelAttribute("loginUserDto") LoginUserDto loginUserDto) {
        log.info("ENTER COURSE UNITS MANAGE PAGE");
        return "courses/courseUnitsManage";
    }

}
