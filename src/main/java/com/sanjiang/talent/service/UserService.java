package com.sanjiang.talent.service;

import com.sanjiang.talent.po.User;
import com.sanjiang.talent.vo.MenuDto;

import java.util.List;

public interface UserService {

    List<User> getUser();

    User getUserById(String id);

    User getUserByNameAndPwd(String name, String pwd);

    List<MenuDto> getMenuByLoginuserId(String loginUserId);
}
