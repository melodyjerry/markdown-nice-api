package com.markdown.api.domain;

import lombok.Data;

import java.util.Date;

/**
 * @author lirui
 */
@Data
public class ThemeDO {

    private Long id;

    private String name;

    private String englishName;

    private String screenshot;

    private String qrCode;

    private String author;

    private String description;

    private Date createTime;

    private Date updateTime;
}
