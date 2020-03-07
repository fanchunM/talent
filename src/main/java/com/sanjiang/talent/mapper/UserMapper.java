package com.sanjiang.talent.mapper;

import com.sanjiang.talent.po.User;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface UserMapper {
    @Select("select * from user")
    List<User> getUsers();

    User getUserById(String id);
}
