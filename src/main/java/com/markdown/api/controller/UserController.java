package com.markdown.api.controller;

import com.markdown.api.entity.User;
import com.markdown.api.mapper.UserMapper;
import com.markdown.api.service.IUserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;

/**
 * @author lirui
 */
@RestController
@EnableSwagger2
@Api(value = "user", tags = "userOperating")
@RequestMapping("/user")
@CrossOrigin(origins = "*",maxAge = 3600)
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping("users")
    public List<User> userQuery() {
        List<User> users = userService.userQuery();
        return users;
    }
/*
    @GetMapping("users/:id")
    public User userQueryOne(int id) {
        return userMapper.getOne(id);
    }

    @PostMapping("users")
    public void userInsert(User user) {
        userMapper.insert(user);
    }

    @GetMapping("update")
    public void userUpdate(User user) {
        userMapper.update(user);
    }*/

    /*@GetMapping("delete")
    public void userDelete(int id) {
        userMapper.delete(id);
    }*/
}
