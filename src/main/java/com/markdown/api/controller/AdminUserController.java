package com.markdown.api.controller;

import com.alibaba.fastjson.JSONObject;
import com.markdown.api.annotation.JwtIgnore;
import com.markdown.api.entity.User;
import com.markdown.api.response.Result;
import com.markdown.api.service.UserService;
import com.markdown.api.util.Audience;
import com.markdown.api.util.JwtTokenUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

/**
 * @author lirui
 */
@Slf4j
@RestController
public class AdminUserController {
    @Autowired
    private Audience audience;

    @Autowired
    private UserService userService;

    @JwtIgnore
    @PostMapping("/login")
    public Result adminLogin(HttpServletResponse response, String username, String password) throws IOException {
        // 这里模拟测试, 默认登录成功，返回用户ID和角色信息
        String userId = UUID.randomUUID().toString();
        String role = "user";
        if(userService.findPersonByUsername(username) == null) {
            User user = new User();
            user.setUsername(username);
            user.setPassword(password);
            userService.insert(user);
        }
        if(!password.equals(userService.findPersonByUsername(username).getPassword())) {
            return Result.FAIL("登录失败");
        }

        // 创建token
        String token = JwtTokenUtil.createJWT(userId, username, role, audience);
        log.info("### 登录成功, token={} ###", token);
        // 将token放在响应头
        response.setHeader(JwtTokenUtil.AUTH_HEADER_KEY, JwtTokenUtil.TOKEN_PREFIX + token);
        // 将token响应给客户端
        JSONObject result = new JSONObject();
        result.put("token", token);
        return Result.SUCCESS(result);
    }

}
