package com.markdown.api.service;

import com.markdown.api.entity.User;
import com.markdown.api.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lirui
 */
@Service
public class UserService{

    @Autowired
    private UserMapper userMapper;

    public List<User> userQuery() {
        return userMapper.getAll();
    }
}
