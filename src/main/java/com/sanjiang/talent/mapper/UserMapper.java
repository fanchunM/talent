package com.sanjiang.talent.mapper;

import com.sanjiang.talent.po.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper{
    @Select("select * from user")
    List<User> getUsers();

    User getUserById(String id);

    @Select("select * from user where user_name = #{name} and password = #{pwd}")
    User getUserByNameAndPwd(@Param("name") String name, @Param("pwd") String pwd);

}
