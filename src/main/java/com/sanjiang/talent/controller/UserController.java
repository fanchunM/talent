package com.sanjiang.talent.controller;

import com.sanjiang.talent.po.Role;
import com.sanjiang.talent.po.User;
import com.sanjiang.talent.service.UserService;
import com.sanjiang.talent.vo.CommonComboDto;
import com.sanjiang.talent.vo.LoginUserDto;
import com.sanjiang.talent.vo.UserDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@SessionAttributes(value= {"loginUserDto"})
@RequestMapping("/user/")
@Slf4j
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("login")
    public ResponseEntity<String> login(@RequestBody UserDTO userDTO, ModelMap modelMap) {
        User userByNameAndPwd = userService.getUserByNameAndPwdAndIsTeacher(userDTO.getUserName(), userDTO.getPassword(), userDTO.getIsTeacher());
        LoginUserDto loginUserDto = new LoginUserDto();
        loginUserDto.setLoginUserId(userByNameAndPwd.getId());
        loginUserDto.setPosition(userByNameAndPwd.getPosition());
        loginUserDto.setDepartment(userByNameAndPwd.getDepartment());
        loginUserDto.setChsName(userByNameAndPwd.getChsName());
        loginUserDto.setPassword(userByNameAndPwd.getPassword());
        loginUserDto.setIsTeacher(userByNameAndPwd.getIsTeacher());
        modelMap.addAttribute("loginUserDto", loginUserDto);
        return new ResponseEntity<String>("{\"success\":true}", HttpStatus.OK);
    }

    @GetMapping("student_manage")
    public Map<String, Object> getStudentManage(@RequestParam(defaultValue = "1") String page,
                                                @RequestParam(defaultValue = "20") String rows,
                                                @RequestParam String type) {

        return userService.getStudentManage(Integer.valueOf(page), Integer.valueOf(rows), type);
    }

    @PostMapping("create_student")
    public ResponseEntity<String> createStudentOrTeqacher(@RequestBody User user, @ModelAttribute("loginUserDto") LoginUserDto loginUserDto) {
        userService.createStudentOrTeacher(user, loginUserDto.getLoginUserId());
        return new ResponseEntity<String>("{\"success\":true}", HttpStatus.OK);
    }

    @PostMapping("delete_student_or_teacher")
    public ResponseEntity<String> deleteStudentOrTeacher(@RequestBody List<String> ids) {
        log.info("delete student or teacher where id in {}", ids);
        userService.deleteStudentOrTeacher(ids);
        return new ResponseEntity<String>("{\"success\":true}", HttpStatus.OK);
    }

    @PostMapping("update_pwd")
    public ResponseEntity<String> updatePwd(@ModelAttribute("loginUserDto") LoginUserDto loginUserDto, @RequestParam String oldPwd, @RequestParam String newPwd) {
        log.info("update password where oldPwd = {} and newPwd = {}", oldPwd, newPwd);
        userService.updatePwd(loginUserDto.getLoginUserId(), oldPwd, newPwd);
        return new ResponseEntity<String>("{\"success\":true}", HttpStatus.OK);
    }

    @GetMapping("role_manage")
    public Map<String, Object> getRoleManage(@RequestParam(defaultValue = "1") String page,
                                                @RequestParam(defaultValue = "20") String rows) {
        return userService.getRoleManage(Integer.valueOf(page), Integer.valueOf(rows));
    }

    @PostMapping("create_role")
    public ResponseEntity<String> createRole(@RequestBody Role role) {
        userService.createRole(role);
        return new ResponseEntity<String>("{\"success\":true}", HttpStatus.OK);
    }

    @PostMapping("delete_role")
    public ResponseEntity<String> deleteRole(@RequestBody List<String> ids) {
        log.info("delete role where id in {}", ids);
        userService.deleteRole(ids);
        return new ResponseEntity<String>("{\"success\":true}", HttpStatus.OK);
    }

    @GetMapping("get_user")
    public List<CommonComboDto> getUserCombobox(@RequestParam(defaultValue = "") String q) {
        List<User> user = userService.getUser(q);
        List<CommonComboDto> commonComboDtos = new ArrayList<>();
        user.stream().forEach(o -> {
            CommonComboDto commonComboDto = new CommonComboDto();
            commonComboDto.setValue(o.getId());
            commonComboDto.setText(o.getChsName());
            commonComboDtos.add(commonComboDto);
        });
        return commonComboDtos;
    }

}
