package com.sanjiang.talent.mapper;

import com.sanjiang.talent.po.User;
import com.sanjiang.talent.vo.UserDTO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
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

}
