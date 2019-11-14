package com.markdown.api.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author lirui
 */
@Data
public class UserTheme {

    private int id;

    private int userId;

    private int themeId;

    private Date createTime;

    private Date updateTime;
}
