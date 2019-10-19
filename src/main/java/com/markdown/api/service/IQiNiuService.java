package com.markdown.api.service;

import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;

import java.io.File;
import java.io.InputStream;

/**
 * Company      :
 * Created By   : Lr
 * Created Date : 2019/10/16 10:24
 * Description  : 七牛云文件上传抽象服务
 */
public interface IQiNiuService {
    Response uploadFile(File file) throws QiniuException;

    Response uploadFile(InputStream inputStream) throws QiniuException;
}
