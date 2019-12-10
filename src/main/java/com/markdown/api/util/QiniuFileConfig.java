package com.markdown.api.util;

import com.google.gson.Gson;
import com.markdown.api.util.QiniuProperties;
import com.qiniu.storage.BucketManager;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class QiniuFileConfig {

    /**
     * 華東機房,配置自己空間所在的區域
     */
    @Bean
    public com.qiniu.storage.Configuration qiniuConfig() {
        return new com.qiniu.storage.Configuration(QiniuProperties.REGION);
    }

    /**
     * 構建一個七牛上傳工具實例
     */
    @Bean
    public UploadManager uploadManager() {
        return new UploadManager(qiniuConfig());
    }

    /**
     * 認證信息實例
     */
    @Bean
    public Auth auth() {
        return Auth.create(QiniuProperties.ACCESS_KEY, QiniuProperties.SECRET_KEY);
    }

    /**
     * 構建七牛空間管理實例
     */
    @Bean
    public BucketManager bucketManager() {
        return new BucketManager(auth(), qiniuConfig());
    }

    @Bean
    public Gson gson() {
        return new Gson();
    }
}
