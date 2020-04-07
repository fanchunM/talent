package com.sanjiang.talent.service;

import com.sanjiang.talent.po.User;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface UserService {

    List<User> getUser();

    User getUserById(String id);

    User getUserByNameAndPwd(String name, String pwd);
}
