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
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public List<User> userQuery() {
        return userMapper.getAll();
    }

    public User getOne(Integer id) {
        return userMapper.getOne(id);
    }

    public void insert(User user) {
        userMapper.insert(user);
    }

    public void update(User user) {
        userMapper.update(user);
    }

    public User findPersonByUsername(String username) {
        return userMapper.getOneByParam(username);
    }

    public User findPersonByGitid(String githubId) {
        return userMapper.getOneByGitid(githubId);
    }
}
