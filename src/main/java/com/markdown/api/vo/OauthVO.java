package com.markdown.api.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel(description = "登录返回模型")
public class OauthVO {

    @ApiModelProperty(value = "id", example = "0")
    private Long id;

    @ApiModelProperty(value = "用户名", example = "qwer")
    private String username;

    @ApiModelProperty(value = "头像", example = "/.jpg")
    private String avatar;

    @ApiModelProperty(value = "githubid", example = "65736")
    private String githubId;

    @ApiModelProperty(value = "微信名", example = "0")
    private String wechat;

    @ApiModelProperty(value = "微信公众号", example = "0")
    private String wechatPlatform;

    @ApiModelProperty(value = "建立时间", example = "0")
    private Date createTime;

    @ApiModelProperty(value = "修改时间", example = "0")
    private Date updateTime;

    @ApiModelProperty(value = "验证信息", example = "d8sje7sksdtn3mmsj")
    private String token;
}
