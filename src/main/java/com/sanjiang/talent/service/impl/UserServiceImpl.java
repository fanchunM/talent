package com.sanjiang.talent.service.impl;

import com.sanjiang.talent.mapper.UserMapper;
import com.sanjiang.talent.po.User;
import com.sanjiang.talent.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public List<User> getUser() {
        return userMapper.getUsers();
    }

    @Override
    public User getUserById(String id) {
        return userMapper.getUserById(id);
    }
}
