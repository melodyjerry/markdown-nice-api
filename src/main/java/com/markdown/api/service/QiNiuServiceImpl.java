package com.markdown.api.service;

import com.google.gson.Gson;
import com.markdown.api.util.QiniuProperties;
import com.markdown.api.vo.PicVO;
import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import com.qiniu.util.StringMap;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;
import java.io.InputStream;

/**
 * Company      :
 * Created Date : 2019/10/16 10:24
 * Description  : 七牛云文件上传实现类
 * @author lirui
 */
@Service
public class QiNiuServiceImpl implements IQiNiuService, InitializingBean {

    private UploadManager uploadManager;

    private Auth auth;

    /** 定義七牛雲上傳的相關策略*/
    private StringMap putPolicy;

    public QiNiuServiceImpl(UploadManager uploadManager, Auth auth) {
        this.uploadManager = uploadManager;
        this.auth = auth;
    }



    /**
     * 以流的形式上傳
     */
    @Override
    public PicVO uploadFile(InputStream inputStream) throws QiniuException {
        PicVO picVO = new PicVO();
        Response response = this.uploadManager.put(inputStream, null, getUploadToken(), null, null);
        int retry = 0;
        int retryMax = 3;
        while (response.needRetry() && retry < retryMax) {
            response = this.uploadManager.put(inputStream, null, getUploadToken(), null, null);
            retry++;
        }

        DefaultPutRet putRet;

        try {
            putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
            picVO.setUrl(QiniuProperties.QINIUIMAGEDOMAIN + "/" + putRet.hash);
        } catch (QiniuException ex) {
            Response r = ex.response;
            System.err.println(r.toString());
            try {
                System.err.println(r.bodyString());
            } catch (QiniuException ex2) {
                // ignore
            }
        }

        return picVO;
    }

    /**
     * 实例化StringMap
     */
    @Override
    public void afterPropertiesSet() {
        this.putPolicy = new StringMap();
        putPolicy.put("returnBody", "{\"key\":\"$(key)\",\"hash\":\"$(etag)\",\"bucket\":\"$(bucket)\",\"width\":$(imageInfo.width),\"height\":$(imageInfo.height)}");
    }
    /**
     * 获取上传凭证
     */
    private String getUploadToken(){
        return this.auth.uploadToken(QiniuProperties.BUCKET,null,3600,putPolicy);
    }

}
