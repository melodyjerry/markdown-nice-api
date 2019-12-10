package com.markdown.api.controller;

import com.markdown.api.annotation.JwtIgnore;
import com.markdown.api.response.Result;
import com.markdown.api.service.UserService;
import com.markdown.api.vo.OauthVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import me.zhyd.oauth.model.AuthCallback;
import me.zhyd.oauth.request.AuthRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author lirui
 */
@Slf4j
@RestController
@EnableSwagger2
@Api(value = "Auth", tags = "第三方登录")
public class RestAuthController {

    @Autowired
    private UserService userService;

    /**
     * @param state    没有传值，只是适应版本
     */
    @GetMapping("oauth/render/github")
    @ApiOperation(value = "第三方入口", notes = "***")
    @JwtIgnore
    public void renderAuth(HttpServletResponse response, String state) throws IOException {
        AuthRequest authRequest = userService.getAuthRequest();
        response.sendRedirect(authRequest.authorize(state));
    }

    @GetMapping("oauth/callback/github")
    @ApiOperation(value = "第三方登录后回调", notes = "***")
    @JwtIgnore
    public Result<OauthVO> login(AuthCallback authCallback) {
        OauthVO oauthVO = userService.restOauth(authCallback);
        return Result.SUCCESS(oauthVO);
    }


}
