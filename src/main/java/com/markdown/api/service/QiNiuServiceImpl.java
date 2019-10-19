package com.markdown.api.service;

import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.BucketManager;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;
import com.qiniu.util.StringMap;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.InputStream;

/**
 * Company      :
 * Created By   : Lr
 * Created Date : 2019/10/16 10:24
 * Description  : 七牛云文件上传实现类
 */
@Service
public class QiNiuServiceImpl implements IQiNiuService, InitializingBean {

    @Autowired
    private UploadManager uploadManager;
    @Autowired
    private BucketManager bucketManager;
    @Autowired
    private Auth auth;

    @Value("${qiniu.bucket}")
    private String bucket;
    // 定義七牛雲上傳的相關策略
    private StringMap putPolicy;

    /**
     * 以文件的形式上傳
     *
     * @param file
     * @return
     * @throws QiniuException
     */
    @Override
    public Response uploadFile(File file) throws QiniuException {
        Response response = this.uploadManager.put(file,null,getUploadToken());
        int retry = 0;
        /**
         * 重传次数
         */
        while(response.needRetry() && retry < 3){
            this.uploadManager.put(file,null,getUploadToken());
            retry++;
        }
        return response;
    }

    /**
     * 以流的形式上傳
     *
     * @param inputStream
     * @return
     * @throws QiniuException
     */
    @Override
    public Response uploadFile(InputStream inputStream) throws QiniuException {
        Response response = this.uploadManager.put(inputStream, null, getUploadToken(), null, null);
        int retry = 0;
        while (response.needRetry() && retry < 3) {
            response = this.uploadManager.put(inputStream, null, getUploadToken(), null, null);
            retry++;
        }

        return response;
    }

    /**
     * 实例化StringMap
     * @throws Exception
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        this.putPolicy = new StringMap();
        putPolicy.put("returnBody", "{\"key\":\"$(key)\",\"hash\":\"$(etag)\",\"bucket\":\"$(bucket)\",\"width\":$(imageInfo.width),\"height\":$(imageInfo.height)}");
    }
    /**
     * 获取上传凭证
     * @return
     */
    private String getUploadToken(){
        return this.auth.uploadToken(bucket,null,3600,putPolicy);
    }

}
