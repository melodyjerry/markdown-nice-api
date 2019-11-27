package com.markdown.api.util;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author lirui
 * 第三方配置信息类
 */
@Data
@ConfigurationProperties(prefix = "authconfigure")
@Component
public class AuthConfigure {

    private String clientId;

    private String clientSecret;

    private String redirectUri;
}
