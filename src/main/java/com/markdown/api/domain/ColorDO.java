package com.markdown.api.domain;

import lombok.Data;

import java.util.Date;

/**
 * @author lirui
 */
@Data
public class ColorDO {

  private Long id;

  private Long themeId;

  private String css;

  private String longPic;

  private String author;

  private Date createTime;

  private Date updateTime;

}
