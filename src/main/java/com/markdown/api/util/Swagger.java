package com.markdown.api.util;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@ConfigurationProperties(prefix = "swagger")
@Component
public class Swagger {

    private String foreverToken;

    private String title;

    private String description;

    private String version;
}
