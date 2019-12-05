package com.markdown.api.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "注册传入模型")
public class RegisterDTO {

    @ApiModelProperty(example = "qwer", required = true)
    private String username;

    @ApiModelProperty(example = "123", required = true)
    private String password;
}
