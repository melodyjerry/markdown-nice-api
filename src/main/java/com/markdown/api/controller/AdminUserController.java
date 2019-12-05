package com.markdown.api.controller;

import com.markdown.api.annotation.JwtIgnore;
import com.markdown.api.dto.RegisterDTO;
import com.markdown.api.dto.UserDTO;
import com.markdown.api.response.Result;
import com.markdown.api.service.AdminUserService;
import com.markdown.api.vo.OauthVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

/**
 * @author lirui
 */
@Slf4j
@EnableSwagger2
@Api(value = "userlogin", tags = "登录注册入口")
@RestController
public class AdminUserController {

    @Resource
    private AdminUserService adminUserService;

    @JwtIgnore
    @PostMapping("/signIn")
    @ApiOperation(value = "登录接口")
    public Result<OauthVO> adminLogin(HttpServletResponse response, @RequestBody UserDTO userDTO) {
        return adminUserService.login(response, userDTO);
    }

    @JwtIgnore
    @PostMapping("/register")
    @ApiOperation(value = "注册接口")
    public Result register(@RequestBody RegisterDTO registerDTO) {
        return Result.SUCCESS();
    }

}
