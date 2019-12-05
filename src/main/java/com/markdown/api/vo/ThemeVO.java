package com.markdown.api.vo;

import com.markdown.api.domain.ThemeDO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @author lirui
 */
@Data
@ApiModel(description = "主题列表页面返回模型")
public class ThemeVO {

    @ApiModelProperty(value = "id", example = "0")
    private Long id;

    @ApiModelProperty(value = "主题名", example = "橙红")
    private String name;

    @ApiModelProperty(value = "英文名", example = "orange")
    private String englishName;

    @ApiModelProperty(value = "展示图", example = "/.jpg")
    private String screenshot;

    @ApiModelProperty(value = "二维码", example = "/.jpg")
    private String qrCode;

    @ApiModelProperty(value = "作者", example = "佚名")
    private String author;

    @ApiModelProperty(value = "介绍", example = "balabala")
    private String description;

    private Date createTime;

    private Date updateTime;
}
