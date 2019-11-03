package com.markdown.api.entity;

import lombok.Data;

import java.util.Date;
@Data
public class User {

    private int id;

    private String githubId;

    private String wechat;

    private String wechatPlatform;

    private Date createTime;

    private Date updateTime;

}
