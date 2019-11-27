package com.markdown.api.controller;

import com.markdown.api.annotation.JwtIgnore;
import com.markdown.api.entity.User;
import com.markdown.api.service.UserService;
import com.markdown.api.util.AuthConfigure;
import io.swagger.annotations.Api;
import me.zhyd.oauth.config.AuthConfig;
import me.zhyd.oauth.model.AuthCallback;
import me.zhyd.oauth.model.AuthResponse;
import me.zhyd.oauth.model.AuthUser;
import me.zhyd.oauth.request.AuthGithubRequest;
import me.zhyd.oauth.request.AuthRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author lirui
 */
@RestController
@EnableSwagger2
@Api(value = "Auth", tags = "authOperation")
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping
public class RestAuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private AuthConfigure authConfigure;

    @RequestMapping("oauth/render/github")
    @JwtIgnore
    public void renderAuth(HttpServletResponse response, String code) throws IOException {
        AuthRequest authRequest = getAuthRequest();
        response.sendRedirect(authRequest.authorize(code));
    }

    @RequestMapping("oauth/callback/github")
    @JwtIgnore
    public User login(AuthCallback authCallback) {
        AuthRequest authRequest = getAuthRequest();
        AuthResponse authResponse = authRequest.login(authCallback);
        AuthUser authUser = (AuthUser) authResponse.getData();
        User u = userService.findPersonByGitid(authUser.getUsername());
        if (userService.findPersonByGitid(authUser.getUsername()) == null) {
            User user = new User();
            user.setGithubId(authUser.getUsername());
            user.setAvatar(authUser.getAvatar());
            userService.insert(user);
            return user;
        }
        return userService.findPersonByGitid(authUser.getUsername());
    }

    private AuthRequest getAuthRequest() {
        return new AuthGithubRequest(AuthConfig.builder()
                .clientId(authConfigure.getClientId())
                .clientSecret(authConfigure.getClientSecret())
                .redirectUri(authConfigure.getRedirectUri())
                .build());
    }

}
