package com.markdown.api.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author lirui
 */
@Data
public class Color {

  private int id;

  private int themeId;

  private String css;

  private String longPic;

  private String author;

  private Date createTime;

  private Date updateTime;

}
