package com.sanjiang.talent.controller;

import com.sanjiang.talent.po.User;
import com.sanjiang.talent.service.UserService;
import com.sanjiang.talent.vo.LoginUserDto;
import com.sanjiang.talent.vo.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@RestController
@SessionAttributes(value= {"loginUserDto"})
@RequestMapping("/user/")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("login")
    public ResponseEntity<String> login(@RequestBody UserDTO userDTO, ModelMap modelMap) {
        User userByNameAndPwd = userService.getUserByNameAndPwd(userDTO.getName(), userDTO.getPassword());
        LoginUserDto loginUserDto = new LoginUserDto();
        loginUserDto.setChsName(userByNameAndPwd.getName());
        loginUserDto.setPassword(userByNameAndPwd.getPassword());
        loginUserDto.setStudent(userByNameAndPwd.isStudent());
        modelMap.addAttribute("loginUserDto", loginUserDto);
        return new ResponseEntity<String>("{\"success\":true}", HttpStatus.OK);
    }
}
