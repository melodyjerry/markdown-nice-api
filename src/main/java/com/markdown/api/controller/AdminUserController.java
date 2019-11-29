package com.markdown.api.controller;

import com.alibaba.fastjson.JSONObject;
import com.markdown.api.annotation.JwtIgnore;
import com.markdown.api.entity.User;
import com.markdown.api.response.Result;
import com.markdown.api.service.UserService;
import com.markdown.api.util.Audience;
import com.markdown.api.util.JwtTokenUtil;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

/**
 * @author lirui
 */
@Slf4j
@EnableSwagger2
@Api(value = "userlogin", tags = "login")
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
        String role = "user";
        User user = new User();
        if(userService.findPersonByUsername(username) == null) {
            user.setUsername(username);
            user.setPassword(password);
            userService.insert(user);
        }
        if(!password.equals(userService.findPersonByUsername(username).getPassword())) {
            return Result.FAIL("登录失败");
        }

        String userId = String.valueOf(userService.findPersonByUsername(username).getId());
        // 创建token
        String token = JwtTokenUtil.createJWT(password, userId, role, audience);
        log.info("### 登录成功, token={} ###", token);
        // 将token放在响应头
        response.setHeader(JwtTokenUtil.AUTH_HEADER_KEY, JwtTokenUtil.TOKEN_PREFIX + token);
        // 将token响应给客户端
        JSONObject result = new JSONObject();
        result.put("token", token);
        return Result.SUCCESS(result);
    }

}
