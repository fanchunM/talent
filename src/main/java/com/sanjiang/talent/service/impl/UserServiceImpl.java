package com.sanjiang.talent.service.impl;

import com.sanjiang.talent.po.User;
import com.sanjiang.talent.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Service
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class UserServiceImpl implements UserService {
    @Override
    public List<User> getUser() {
        List<User> list = new ArrayList();
        User user = new User();
        user.setUserId("1");
        user.setGender("女");
        user.setName("小红");
        User user2 = new User();
        user.setUserId("2");
        user.setGender("男");
        user.setName("小刚");
        list.add(user);
        list.add(user2);
        return list;
    }
}
