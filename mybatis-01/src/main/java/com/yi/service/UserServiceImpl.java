package com.yi.service;


import com.yi.mapper.UserMapper;
import com.yi.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    public User queryByName(String username) {
        return userMapper.queryByName(username);
    }
}
