package com.markdown.api.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author lirui
 */
@Data
@ApiModel(description = "登录传入模型")
public class UserDTO {

    @ApiModelProperty(example = "32")
    private Long id;

    @ApiModelProperty(example = "qwer", value = "id和username二者必填一项")
    private String username;

    @ApiModelProperty(example = "123", required = true)
    private String password;

}
