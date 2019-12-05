package com.markdown.api.domain;

import lombok.Data;

import java.util.Date;

/**
 * @author lirui
 */
@Data
public class UserThemeDO {

    private Long id;

    private Long userId;

    private Long themeId;

    private Date createTime;

    private Date updateTime;
}
