package com.sanjiang.talent.controller;

import com.sanjiang.talent.service.UserService;
import com.sanjiang.talent.vo.LoginUserDto;
import com.sanjiang.talent.vo.MenuDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpSession;
import java.util.List;

@Slf4j
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

    @GetMapping("student_manage")
    public String enterStudentManagePage(@ModelAttribute("loginUserDto") LoginUserDto loginUserDto) {
        log.info("ENTER STUDENT MANAGE PAGE");
        return "users/studentManage";
    }

    @GetMapping("teacher_manage")
    public String enterTeacherManagePage(@ModelAttribute("loginUserDto") LoginUserDto loginUserDto) {
        log.info("ENTER TEACHER MANAGE PAGE");
        return "users/teacherManage";
    }

    @GetMapping("personal_manage")
    public String enterPersonalManagePage(@ModelAttribute("loginUserDto") LoginUserDto loginUserDto) {
        log.info("ENTER PERSONAL MANAGE PAGE");
        return "users/personalManage";
    }

    @GetMapping("role_permission_manage")
    public String enterRolePermissionManagePage(@ModelAttribute("loginUserDto") LoginUserDto loginUserDto) {
        log.info("ENTER ROLE PERMISSION MANAGE PAGE");
        return "users/rolePermissionManage";
    }

    @GetMapping("logout")
    public String logout(@ModelAttribute("loginUserDto") LoginUserDto loginUserDto, HttpSession session, SessionStatus status) {
        status.setComplete();
        session.removeAttribute("loginUserDto");
        return "redirect:login";
    }
}
