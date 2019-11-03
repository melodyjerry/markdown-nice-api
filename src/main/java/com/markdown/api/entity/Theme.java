package com.markdown.api.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author lirui
 */
@Data
public class Theme {

    private int id;

    private String name;

    private String englishName;

    private String screenshot;

    private String qrCode;

    private String author;

    private String description;

    private Date createTime;

    private Date updateTime;
}
