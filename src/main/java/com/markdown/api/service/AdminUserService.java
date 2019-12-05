package com.markdown.api.service;

import com.alibaba.fastjson.JSONObject;
import com.markdown.api.domain.UserDO;
import com.markdown.api.dto.UserDTO;
import com.markdown.api.mapper.UserMapper;
import com.markdown.api.response.Result;
import com.markdown.api.response.ResultCode;
import com.markdown.api.util.Audience;
import com.markdown.api.util.JwtTokenUtil;
import com.markdown.api.vo.OauthVO;
import io.swagger.annotations.ApiModelProperty;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

/**
 * @author lirui
 * 用户登录
 */
@Slf4j
@Service
public class AdminUserService {
    @Resource
    private Audience audience;

    @Resource
    private UserMapper userMapper;

    /**
     * 用户登录
     * @param response
     * @param userDTO
     * @return Result
     */
    public Result login(HttpServletResponse response,UserDTO userDTO) {
        String role = "user";
        UserDO userDO;
        if (userDTO.getId() != null) {
            userDO = userMapper.getOne(userDTO.getId());
        } else if (StringUtils.isNotBlank(userDTO.getUsername())) {
            userDO = userMapper.getOneByUsername(userDTO.getUsername());
        } else {
            return Result.FAIL(ResultCode.USER_NOT_EXIST);
        }
        if (userDO == null) {
            return Result.FAIL(ResultCode.USER_NOT_EXIST);
        }
        if (!userDTO.getPassword().equals(userDO.getPassword())) {
            return Result.FAIL(ResultCode.USER_LOGIN_ERROR);
        }
        String userId = String.valueOf(userDTO.getId());
        // 创建token
        String token = JwtTokenUtil.createJWT(userDTO.getPassword(), userId, role, audience);
        log.info("### 登录成功, token={} ###", token);
        // 将token放在响应头
        response.setHeader(JwtTokenUtil.AUTH_HEADER_KEY, JwtTokenUtil.TOKEN_PREFIX + token);
        // 将token响应给客户端
        OauthVO oauthVO = new OauthVO();
        oauthVO.setToken(token);
        return Result.SUCCESS(oauthVO);
    }

    /**
     * 用户注册
     */
}
