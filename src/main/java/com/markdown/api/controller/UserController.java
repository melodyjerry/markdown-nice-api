package com.markdown.api.controller;

import com.markdown.api.domain.UserDO;
import com.markdown.api.mapper.UserMapper;
import com.markdown.api.service.UserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author lirui
 */
@RestController
@EnableSwagger2
@Api(value = "user", tags = "用户模块")
public class UserController {

    @Autowired
    private UserService userService;

    @Resource
    private UserMapper userMapper;

    @GetMapping("users")
    public List<UserDO> userQuery() {
        List<UserDO> users = userService.userQuery();
        return users;
    }

    @GetMapping("users/{id}")
    public UserDO userQueryOne(@PathVariable Long id) {
        return userService.getOne(id);
    }

    @PostMapping("users")
    public void userInsert(UserDO user) {
        userMapper.insert(user);
    }

    @PutMapping("users")
    public void userUpdate(UserDO user) {
        userService.update(user);
    }

    // @PatchMapping("users/id")

    /*@GetMapping("delete")
    public void userDelete(int id) {
        userMapper.delete(id);
    }*/
}
