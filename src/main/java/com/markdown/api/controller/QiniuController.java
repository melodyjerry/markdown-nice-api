package com.markdown.api.controller;

import com.markdown.api.annotation.JwtIgnore;
import com.markdown.api.service.QiniuService;
import com.markdown.api.util.Audience;
import com.markdown.api.util.JwtTokenUtil;
import com.markdown.api.vo.PicVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * api-value：定义名称，如果没有定义，则默认显示类名
 *
 * @author lirui
 */
@RestController
@EnableSwagger2
@Api(value = "qiniu", tags = "七牛云")
@RequestMapping("/qiniu")
public class QiniuController {
    @Autowired
    private QiniuService qiniuService;
    @Autowired
    private Audience audience;

    @PostMapping("upload")
    @ApiOperation(value = "图片上传接口")
    public PicVO uploadFile(@RequestParam(value = "file") MultipartFile file, HttpServletRequest response) throws IOException {
        String userId = JwtTokenUtil.getUserId(response.getHeader("Authorization").substring(7), audience.getBase64Secret());
        String filename = file.getOriginalFilename();
        return qiniuService.uploadFile(file.getInputStream(), userId, filename);
    }
}
