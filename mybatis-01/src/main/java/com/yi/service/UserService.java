package com.yi.service;

import com.yi.pojo.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    public User queryByName(String name);
}

