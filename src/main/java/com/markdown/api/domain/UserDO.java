package com.markdown.api.domain;

import lombok.Data;

import java.util.Date;

@Data
public class UserDO {

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
