package com.sanjiang.talent.service;

import com.sanjiang.talent.po.Role;
import com.sanjiang.talent.po.User;
import com.sanjiang.talent.po.course.Moudle;
import com.sanjiang.talent.po.course.Platform;
import com.sanjiang.talent.vo.MenuDto;

import java.util.List;
import java.util.Map;

public interface UserService {

    List<User> getUser(String q);

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

    /**
     * 获取权限列表
     * @param page
     * @param rows
     * @return
     */
    Map<String, Object> getRoleManage(Integer page, Integer rows);

    /**
     * 创建角色
     */
    void createRole(Role role);

    /**
     * 删除角色
     * @param ids
     */
    void deleteRole(List<String> ids);

    /**
     * 获取角色用户
     * @param page
     * @param rows
     * @param roleId
     */
    Map<String, Object> getRoleUser(Integer page, Integer rows, String roleId);

    /**
     * 创建角色用户
     * @param roleId
     * @param userId
     */
    void createRoleUser(String roleId, String userId);

    /**
     * 获取角色菜单
     * @param roleId
     * @return
     */
    List<MenuDto> getRoleMenu(String roleId);

    /**
     * 添加角色菜单
     * @param roleId
     * @param menuIdArray
     */
    void addRoleMenu(String roleId, String menuIdArray);

    /**
     * 删除角色用户
     * @param roleId
     * @param userId
     * @return
     */
    int deleteRoleUser(String roleId, String userId);

    /**
     * 获取平台列表
     * @param page
     * @param rows
     * @return
     */
    Map<String, Object> getPlatformManage(Integer page, Integer rows);

    /**
     * 获取模块列表
     * @param page
     * @param rows
     * @return
     */
    Map<String, Object> getMoudleManage(Integer page, Integer rows);

    /**
     * 新增平台
     * @param platform
     */
    void createPlatform(Platform platform);

    /**
     * 删除平台
     * @param ids
     */
    void deletePlatform(List<String> ids);


    /**
     * 新增模块
     * @param moudle
     */
    void createMoudle(Moudle moudle);

    /**
     * 删除模块
     * @param ids
     */
    void deleteMoudle(List<String> ids);

    List<Platform> getPlatform(String q);
}
