package com.markdown.api.service;

import com.markdown.api.domain.UserDO;
import com.markdown.api.mapper.UserMapper;
import com.markdown.api.util.AuthConfigure;
import com.markdown.api.vo.OauthVO;
import me.zhyd.oauth.config.AuthConfig;
import me.zhyd.oauth.model.AuthCallback;
import me.zhyd.oauth.model.AuthResponse;
import me.zhyd.oauth.model.AuthUser;
import me.zhyd.oauth.request.AuthGithubRequest;
import me.zhyd.oauth.request.AuthRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author lirui
 */
@Service
public class UserService {

    @Resource
    private UserMapper userMapper;

    @Autowired
    private AuthConfigure authConfigure;

    public List<UserDO> userQuery() {
        return userMapper.getAll();
    }

    public UserDO getOne(Long id) {
        return userMapper.getOne(id);
    }

    public void update(UserDO user) {
        userMapper.update(user);
    }

    public OauthVO restOauth(AuthCallback authCallback) {
        AuthRequest authRequest = getAuthRequest();
        //state缓存
        //authRequest.authorize(authCallback.getCode());
        //log.info("authCallback:{}, {}, {}, {}, {}, {}", authCallback.getAuth_code(), authCallback.getAuthorization_code(), authCallback.getCode(), authCallback.getOauthToken(), authCallback.getState(), authCallback.getOauthVerifier());
        AuthResponse authResponse = authRequest.login(authCallback);
        AuthUser authUser = (AuthUser) authResponse.getData();
        UserDO userDO = userMapper.getOneByGitId(authUser.getUsername());
        if (userDO == null) {
            userDO = new UserDO();
            userDO.setGithubId(authUser.getUuid());
            userDO.setUsername(authUser.getNickname());
            userDO.setAvatar(authUser.getAvatar());
            Long id = userMapper.insert(userDO);
            userDO.setId(id);
            return toVO(userDO);
        }
        return toVO(userDO);
    }

    public AuthRequest getAuthRequest() {
        return new AuthGithubRequest(AuthConfig.builder()
                .clientId(authConfigure.getClientId())
                .clientSecret(authConfigure.getClientSecret())
                .redirectUri(authConfigure.getRedirectUri())
                .build());
    }

    private OauthVO toVO(UserDO userDO) {
        OauthVO oauthVO = new OauthVO();
        oauthVO.setId(userDO.getId());
        oauthVO.setAvatar(userDO.getAvatar());
        oauthVO.setCreateTime(userDO.getCreateTime());
        oauthVO.setGithubId(userDO.getGithubId());
        oauthVO.setUpdateTime(userDO.getUpdateTime());
        oauthVO.setWechat(userDO.getWechat());
        oauthVO.setWechatPlatform(userDO.getWechatPlatform());
        return oauthVO;
    }
}
