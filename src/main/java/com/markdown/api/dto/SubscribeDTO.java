package com.markdown.api.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "订阅传入模型")
public class SubscribeDTO {

    @ApiModelProperty(value = "userId")
    private Long userId;

    @ApiModelProperty(value = "themeId")
    private Long themeId;
}
