package com.sanjiang.talent.service;

import com.sanjiang.talent.po.User;
import com.sanjiang.talent.vo.MenuDto;

import java.util.List;
import java.util.Map;

public interface UserService {

    List<User> getUser();

    User getUserById(String id);

    User getUserByNameAndPwd(String name, String pwd);

    List<MenuDto> getMenuByLoginuserId(String loginUserId);

    /**
     * 获取所有学生or教师
     * @param page
     * @param rows
     * @param type
     * @return
     */
    Map<String, Object> getStudentManage(Integer page, Integer rows, String type);
}
