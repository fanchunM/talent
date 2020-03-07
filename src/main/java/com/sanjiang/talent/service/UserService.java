package com.sanjiang.talent.service;

import com.sanjiang.talent.po.User;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface UserService {

    List<User> getUser();
    User getUserById(String id);
}
