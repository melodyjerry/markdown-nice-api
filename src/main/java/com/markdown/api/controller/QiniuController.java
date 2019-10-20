package com.markdown.api.controller;

import com.markdown.api.service.IQiNiuService;
import com.markdown.api.vo.PicVO;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import java.io.IOException;

/** api-value：定义名称，如果没有定义，则默认显示类名
 * @author lirui*/
@RestController
@EnableSwagger2
@Api(value = "qiniu", tags = "fileUpload")
@RequestMapping("/qiniu")
public class QiniuController {

    private IQiNiuService qiniuService;

    public QiniuController(IQiNiuService qiniuService) {
        this.qiniuService = qiniuService;
    }

    @PostMapping("upload")
    public PicVO uploadFile(@RequestParam(value = "file") MultipartFile file) throws IOException {
        return qiniuService.uploadFile(file.getInputStream());
    }
}
