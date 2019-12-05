package com.markdown.api.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel(description = "主题颜色返回模型")
public class ColorVO {

    @ApiModelProperty(value = "id")
    private Long id;

    @ApiModelProperty(value = "主题id")
    private Long themeId;

    @ApiModelProperty(value = "样式")
    private String css;

    @ApiModelProperty(value = "长图")
    private String longPic;

    @ApiModelProperty(value = "作者")
    private String author;

    private Date createTime;

    private Date updateTime;
}
