package com.sanjiang.talent.service;

import com.sanjiang.talent.po.User;
import com.sanjiang.talent.vo.MenuDto;

import java.util.List;
import java.util.Map;

public interface UserService {

    List<User> getUser();

    User getUserById(String id);

    User getUserByNameAndPwdAndIsTeacher(String name, String pwd, int isTeacher);

    List<MenuDto> getMenuByLoginuserId(String loginUserId);

    /**
     * 获取所有学生or教师
     * @param page
     * @param rows
     * @param type
     * @return
     */
    Map<String, Object> getStudentManage(Integer page, Integer rows, String type);

    /**
     * 创建学生或者教师
     * @param user
     * @param loginUserId
     */
    void createStudentOrTeacher(User user, String loginUserId);

    /**
     * 删除学生或者教师
     * @param ids
     */
    void deleteStudentOrTeacher(List<String> ids);

    /**
     * 修改密码
     * @param loginUserId
     * @param oldPwd
     * @param newPwd
     */
    void updatePwd(String loginUserId, String oldPwd, String newPwd);
}
