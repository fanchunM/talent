package com.sanjiang.talent.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sanjiang.talent.mapper.LinkMapper;
import com.sanjiang.talent.mapper.MenuMapper;
import com.sanjiang.talent.mapper.UserMapper;
import com.sanjiang.talent.po.Role;
import com.sanjiang.talent.po.User;
import com.sanjiang.talent.service.UserService;
import com.sanjiang.talent.vo.MenuDto;
import com.sanjiang.talent.vo.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private LinkMapper linkMapper;
    @Autowired
    private MenuMapper menuMapper;

    @Override
    public List<User> getUser() {
        return userMapper.getUsers();
    }

    @Override
    public User getUserById(String id) {
        return userMapper.getUserById(id);
    }

    @Override
    public User getUserByNameAndPwdAndIsTeacher(String name, String pwd, int isTeacher) {
        User userByNameAndPwd = userMapper.getUserByNameAndPwdAndIsTeacher(name, pwd, isTeacher);
        if (null == userByNameAndPwd) {
            throw new RuntimeException("用户名或者密码错误");
        } else {
            return userByNameAndPwd;
        }
    }

    @Override
    public List<MenuDto> getMenuByLoginuserId(String loginUserId) {
        List<Role> linkRoleByLoginUserId = linkMapper.getLinkRoleByLoginUserId(loginUserId);
        List<MenuDto> menus = new ArrayList<>();
        linkRoleByLoginUserId.stream().forEach(o -> {
            List<MenuDto> menuByRoleId = menuMapper.getFatherMenuByRoleId(o.getId());
            menuByRoleId.stream().forEach(o1 -> {
                List<MenuDto> childrenMenuByRoleId = menuMapper.getChildrenMenuByRoleId(o.getId(), o1.getId());
                o1.setChildren(childrenMenuByRoleId);
            });
            menus.addAll(menuByRoleId);
        });
        return menus;
    }

    @Override
    public Map<String, Object> getStudentManage(Integer page, Integer rows, String type) {
        Map<String, Object> map = new HashMap<>(5);
        List<UserDTO> users = userMapper.getStudentOrTeacher((page-1)*rows, rows, Integer.valueOf(type));
        Integer studentOrTeacherCount = userMapper.getStudentOrTeacherCount(Integer.valueOf(type));
        map.put("total", studentOrTeacherCount);
        map.put("rows", users);
        return map;
    }
}
