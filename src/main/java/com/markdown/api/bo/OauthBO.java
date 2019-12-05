package com.markdown.api.bo;

import lombok.Data;

import java.util.Date;

/**
 * @author lirui
 */
@Data
public class OauthBO {

    private Long id;

    private String username;

    private String password;

    private String avatar;

    private String githubId;

    private String wechat;

    private String wechatPlatform;

    private Date createTime;

    private Date updateTime;
}
