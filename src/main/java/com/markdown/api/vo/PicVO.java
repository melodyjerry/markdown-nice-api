package com.markdown.api.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author lirui
 */
@Data
@ApiModel(description = "图床返回模型")
public class PicVO {

    @ApiModelProperty(value = "图片地址")
    String url;
}
