package com.sanjiang.talent.mapper;

import com.sanjiang.talent.po.User;
import com.sanjiang.talent.vo.UserDTO;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper{
    @Select("select * from user")
    List<User> getUsers();

    @Select("select * from user where id = #{id}")
    User getUserById(@Param("id") String id);

    @Select("select * from user where user_name = #{name} and password = #{pwd} and is_teacher = #{isTeacher}")
    User getUserByNameAndPwdAndIsTeacher(@Param("name") String name, @Param("pwd") String pwd, @Param("isTeacher") int isTeacher);

    List<UserDTO> getStudentOrTeacher(@Param("currentIndex") Integer currentIndex, @Param("rows") Integer rows, @Param("type") Integer type);

    @Select("select count(*) from user where is_teacher = #{type}")
    Integer getStudentOrTeacherCount(@Param("type") Integer type);

    void createStudentOrTeacher(User user);

    int deleteStudentOrTeacher(@Param("idList") List<String> idList);

    @Update("update user set user_name=#{user.userName}, chs_name=#{user.chsName}, password=#{user.password}, gender=#{user.gender}, position=#{user.position}, department=#{user.department} where id = #{user.id}")
    int updateStudentOrTeacher(@Param("user") User user);

    @Update("update user set password = #{newPwd} where id = #{loginUserId}")
    int updatePwd(@Param("loginUserId") String loginUserId, @Param("newPwd") String newPwd);

}
