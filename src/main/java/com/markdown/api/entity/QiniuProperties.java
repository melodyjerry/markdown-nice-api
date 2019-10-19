package com.markdown.api.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Company
 * Created By   : Lr
 * Created Date : 2019/10/16 10:24
 * Description  : 七牛配置
 */
@Setter
@Getter
@ConfigurationProperties(prefix = "qiniu")
public class QiniuProperties {

    private String accessKey;

    private String secretKey;

    private String bucket;

    private String prefix;

}
