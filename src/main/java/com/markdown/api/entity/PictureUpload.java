package com.markdown.api.entity;

import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * Company
 * Created By   : Lr
 * Created Date : 2019/10/16 10:24
 * Description  : 图片上传方法
 * @author      :lr
 */
public class PictureUpload {

    public static String accessKey = "accessKey";
    public static String secretKey = "secretKey";
    public static String bucket = "Bucket";

    /**改成他给你的免费的域名。*/
    private static String QINIU_IMAGE_DOMAIN = "http://pzcs5kaeo.bkt.clouddn.com";

    /**普通本地上传 */
    public static String upload(String localFilePath) {
        // 构造一个带指定Zone对象的配置类
        // 这里是华南，对应的2
        Configuration cfg = new Configuration(Zone.zone0());
        UploadManager uploadManager = new UploadManager(cfg);
        String key = null;

        Auth auth = Auth.create(accessKey, secretKey);
        String upToken = auth.uploadToken(bucket);

        DefaultPutRet putRet = null;

        try {
            Response response = uploadManager.put(localFilePath, key, upToken);
            // 解析上传成功的结果
            putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
        } catch (QiniuException ex) {
            Response r = ex.response;
            System.err.println(r.toString());
            try {
                System.err.println(r.bodyString());
            } catch (QiniuException ex2) {
                // ignore
            }
        }
        return QINIU_IMAGE_DOMAIN + "/" + putRet.hash;
    }

    /**文件流上传*/
    public static String upload(MultipartFile file) throws IOException {
        // 构造一个带指定Zone对象的配置类
        Configuration cfg = new Configuration(Zone.zone2());
        UploadManager uploadManager = new UploadManager(cfg);
        // 默认不指定key的情况下，以文件内容的hash值作为文件名
        String key = null;
        DefaultPutRet putRet = null;
        try {
            byte[] uploadBytes = file.getBytes();
            ByteArrayInputStream byteInputStream = new ByteArrayInputStream(uploadBytes);
            Auth auth = Auth.create(accessKey, secretKey);
            String upToken = auth.uploadToken(bucket);
            try {
                Response response = uploadManager.put(byteInputStream, key, upToken, null, null);
                putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
            } catch (QiniuException ex) {
                Response r = ex.response;
                System.err.println(r.toString());
                try {
                    System.err.println(r.bodyString());
                } catch (QiniuException ex2) {
                    // ignore
                }
            }
        } catch (UnsupportedEncodingException ex) {
            // ignore
        }
        return QINIU_IMAGE_DOMAIN + putRet.hash;
    }


}
