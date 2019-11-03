package com.markdown.api.service;

import com.markdown.api.entity.User;
import com.markdown.api.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService{

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> userQuery() {
        return userMapper.getAll();
    }
}
