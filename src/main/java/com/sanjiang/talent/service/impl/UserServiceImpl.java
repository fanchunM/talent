package com.sanjiang.talent.service.impl;

import com.alibaba.fastjson.JSON;
import com.sanjiang.talent.mapper.*;
import com.sanjiang.talent.po.Link;
import com.sanjiang.talent.po.Role;
import com.sanjiang.talent.po.User;
import com.sanjiang.talent.po.course.Course;
import com.sanjiang.talent.po.course.Moudle;
import com.sanjiang.talent.po.course.Platform;
import com.sanjiang.talent.service.UserService;
import com.sanjiang.talent.util.VGUtility;
import com.sanjiang.talent.vo.MenuDto;
import com.sanjiang.talent.vo.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;


@Service
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private LinkMapper linkMapper;
    @Autowired
    private MenuMapper menuMapper;
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private PlatformMapper platformMapper;
    @Autowired
    private MoudleMapper moudleMapper;
    @Autowired
    private CourseMapper courseMapper;

    @Override
    public List<User> getUser(String q) {
        return userMapper.getUsers(q);
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
        List<Link> linkRoleByLoginUserId = linkMapper.getLinkRoleByLoginUserId(loginUserId);
        List<MenuDto> menus = new ArrayList<>();
        Set<String> setFather = new HashSet<>();
        Set<String> setSon = new HashSet<>();
        linkRoleByLoginUserId.stream().forEach(o -> {
            List<MenuDto> menuByRoleId = menuMapper.getFatherMenuByRoleId(o.getRoleId());
            menuByRoleId.stream().forEach(o1 -> {
                setFather.add(o1.getId());
                List<MenuDto> childrenMenuByRoleId = menuMapper.getChildrenMenuByRoleId(o.getRoleId(), o1.getId());
                childrenMenuByRoleId.stream().forEach(o2 -> {
                    setSon.add(o2.getId());
                });
            });
        });
        for (String s : setFather) {
            MenuDto menuById = menuMapper.getMenuById(s);
            List<MenuDto> childrenMenu = menuMapper.getChildrenMenu(s);
            Iterator<MenuDto> iterator = childrenMenu.iterator();
            while (iterator.hasNext()) {
                if (!setSon.contains(iterator.next().getId())) {
                    iterator.remove();
                }
            }
            menuById.setChildren(childrenMenu);
            menus.add(menuById);
        }
        return menus;
    }

    @Override
    public Map<String, Object> getStudentManage(Integer page, Integer rows, String type) {
        Map<String, Object> map = new HashMap<>(5);
        List<UserDTO> users = userMapper.getStudentOrTeacher((page-1)*rows, rows, Integer.valueOf(type));
        users.stream().forEach(o -> {
            o.setCreateByStr(userMapper.getUserById(o.getCreateBy()).getChsName());
            o.setCreateTimeStr(VGUtility.toDateStr(o.getCreateTime(), "yyyy-MM-dd HH:mm:ss"));
        });
        Integer studentOrTeacherCount = userMapper.getStudentOrTeacherCount(Integer.valueOf(type));
        map.put("total", studentOrTeacherCount);
        map.put("rows", users);
        return map;
    }

    @Override
    public void createStudentOrTeacher(User user, String loginUserId) {
        if (!VGUtility.isEmpty(user.getId())) {
            //修改
            userMapper.updateStudentOrTeacher(user);
        } else {
            user.setId(UUID.randomUUID().toString().replace("-", ""));
            user.setCreateBy(loginUserId);
            user.setCreateTime(new Date());
            //新增
            userMapper.createStudentOrTeacher(user);
        }
    }

    @Override
    public void deleteStudentOrTeacher(List<String> ids) {
        userMapper.deleteStudentOrTeacher(ids);
    }

    @Override
    public void updatePwd(String loginUserId, String oldPwd, String newPwd) {
        User userById = userMapper.getUserById(loginUserId);
        if (!userById.getPassword().equals(oldPwd)) {
            throw new RuntimeException("原密码输入错误，请重新输入！");
        } else {
            userMapper.updatePwd(loginUserId, newPwd);
        }
    }

    @Override
    public Map<String, Object> getRoleManage(Integer page, Integer rows) {
        Map<String, Object> map = new HashMap<>(5);
        List<Role> roles = roleMapper.getRoleManage((page-1)*rows, rows);
        Integer roleCount = roleMapper.getRoleCount();
        map.put("total", roleCount);
        map.put("rows", roles);
        return map;
    }

    @Override
    public void createRole(Role role) {
        if (!VGUtility.isEmpty(role.getId())) {
            roleMapper.updateRole(role);
        } else {
            role.setId(UUID.randomUUID().toString().replace("-", ""));
            roleMapper.createRole(role);
        }
    }

    @Override
    public void deleteRole(List<String> ids) {
        roleMapper.deleteRole(ids);
    }

    @Override
    public Map<String, Object> getRoleUser(Integer page, Integer rows, String roleId) {
        Map<String, Object> map = new HashMap<>(5);
        List<UserDTO> users = userMapper.getRoleUser((page-1)*rows, rows, roleId);
        Integer roleUserCount = userMapper.getRoleUserCount(roleId);
        map.put("total", roleUserCount);
        map.put("rows", users);
        return map;
    }

    @Override
    public void createRoleUser(String roleId, String userId) {
        userMapper.createRoleUser(UUID.randomUUID().toString().replace("-", ""), roleId, userId);
    }

    @Override
    public List<MenuDto> getRoleMenu(String roleId) {
        List<String> roleMenu = menuMapper.getRoleMenu(roleId);
        List<MenuDto> menus = new ArrayList<>();
        List<MenuDto> menuByRoleId = menuMapper.getFatherMenu();
        menuByRoleId.stream().forEach(o -> {
            o.setText(o.getName());
            List<MenuDto> childrenMenuByRoleId = menuMapper.getChildrenMenu(o.getId());
            childrenMenuByRoleId.stream().forEach(o1 -> {
                o1.setText(o1.getName());
                if (roleMenu.contains(o1.getId())) {
                    o1.setChecked(true);
                } else {
                    o1.setChecked(false);
                }
            });
            o.setChildren(childrenMenuByRoleId);
        });
        menus.addAll(menuByRoleId);
        return menus;
    }

    @Override
    public void addRoleMenu(String roleId, String menuIdArray) {
        linkMapper.deleteRoleMenu(roleId);
        List<String> strings = JSON.parseArray(menuIdArray, String.class);
        strings.stream().forEach(o -> {
            Link link = new Link();
            link.setId(UUID.randomUUID().toString().replace("-", ""));
            link.setRoleId(roleId);
            link.setLinkId(o);
            link.setType(2);
            linkMapper.addRoleMenu(link);
        });
    }

    @Override
    public int deleteRoleUser(String roleId, String userId) {
        return linkMapper.deleteRoleUser(roleId, userId);
    }

    @Override
    public Map<String, Object> getPlatformManage(Integer page, Integer rows) {
        Map<String, Object> map = new HashMap<>(5);
        List<Platform> roles = platformMapper.getPlatformManage((page-1)*rows, rows);
        Integer platformCount = platformMapper.getPlatformCount();
        map.put("total", platformCount);
        map.put("rows", roles);
        return map;
    }

    @Override
    public Map<String, Object> getMoudleManage(Integer page, Integer rows) {
        Map<String, Object> map = new HashMap<>(5);
        List<Moudle> moudles = moudleMapper.getMoudleManage((page-1)*rows, rows);
        moudles.stream().forEach(o -> {
            o.setPlatformName(platformMapper.getPlatformById(o.getPlatformId()).getName());
        });
        Integer moudleCount = moudleMapper.getMoudleCount();
        map.put("total", moudleCount);
        map.put("rows", moudles);
        return map;
    }

    @Override
    public void createPlatform(Platform platform) {
        if (!VGUtility.isEmpty(platform.getId())) {
            platformMapper.updatePlatform(platform);
        } else {
            platform.setId(UUID.randomUUID().toString().replace("-", ""));
            platformMapper.createPlatform(platform);
        }
    }

    @Override
    public void deletePlatform(List<String> ids) {
        ids.stream().forEach( o -> {
            List<Moudle> moudleByPlatform = moudleMapper.getMoudleByPlatform(o);
            if (moudleByPlatform.size() > 0) {
                throw new RuntimeException("平台中有关联的模块，请先删除模块！");
            }
        });
        platformMapper.deletePlatform(ids);
    }

    @Override
    public void createMoudle(Moudle moudle) {
        if (!VGUtility.isEmpty(moudle.getId())) {
            moudleMapper.updateMoudle(moudle);
        } else {
            moudle.setId(UUID.randomUUID().toString().replace("-", ""));
            moudleMapper.createMoudle(moudle);
        }
    }

    @Override
    public void deleteMoudle(List<String> ids) {
        ids.stream().forEach( o -> {
            List<Course> courseByMoudleId = courseMapper.getCourseByMoudleId(o);
            if (courseByMoudleId.size() > 0) {
                throw new RuntimeException("模块中有关联的课程，请先删除课程！");
            }
        });

        moudleMapper.deleteMoudle(ids);
    }

    @Override
    public List<Platform> getPlatform(String q) {
        return platformMapper.getPlatform(q);
    }

    @Override
    public List<Moudle> getMoudle(String q) {
        return moudleMapper.getMoudle(q);
    }
}
