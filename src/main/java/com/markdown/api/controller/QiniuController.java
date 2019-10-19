package com.markdown.api.controller;

import com.markdown.api.service.IQiNiuService;
import com.qiniu.http.Response;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.io.IOException;

/**
 * Company
 * Created By   : Lr
 * Created Date : 2019/10/16 10:24
 * Description  : 图片上传控制器
 * @author      :lr
 */
@RestController
@EnableSwagger2 // 启动swagger注解
// api-value：定义名称，如果没有定义，则默认显示类名
@Api(value = "qiniu", description = "图片上传接口", tags = "controller")
@RequestMapping("/qiniu")
public class QiniuController {
    @Autowired
    private IQiNiuService qiniuService;
    /**
     * 以流的形式上傳圖片
     *
     * @param ：file
     * @return 返回訪問路徑
     * @throws IOException
     */
    @PostMapping("upload")
    public Response uploadFile(@RequestParam(value = "file") MultipartFile file) throws IOException {
        return qiniuService.uploadFile(file.getInputStream());
    }
}
