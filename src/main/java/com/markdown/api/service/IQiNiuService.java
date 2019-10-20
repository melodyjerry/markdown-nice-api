package com.markdown.api.service;

import com.markdown.api.vo.PicVO;
import com.qiniu.common.QiniuException;
import java.io.InputStream;

/**
 * Company      :
 * Created Date : 2019/10/16 10:24
 * Description  : 七牛云文件上传抽象服务
 * @author lirui
 */
public interface IQiNiuService {

    /**
     * @return PicVO
     */
    PicVO uploadFile(InputStream inputStream) throws QiniuException;
}
