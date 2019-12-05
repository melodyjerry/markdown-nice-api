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
//实现跨域注解
//origin="*"代表所有域名都可访问
//maxAge飞行前响应的缓存持续时间的最大年龄，简单来说就是Cookie的有效期 单位为秒
//若maxAge是负数,则代表为临时Cookie,不会被持久化,Cookie信息保存在浏览器内存中,浏览器关闭Cookie就消失
@CrossOrigin(origins = "*", maxAge = 3600)

public class QiniuController {
    @Autowired
    private QiniuService qiniuService;
    @Autowired
    private Audience audience;

    @PostMapping("upload")
    @ApiOperation(value = "图片上传接口")
    public PicVO uploadFile(@RequestParam(value = "file") MultipartFile file, HttpServletRequest response, String base64Security) throws IOException {
        String userId = JwtTokenUtil.getUserId(response.getHeader("Authorization").substring(7), audience.getBase64Secret());
        String filename = file.getOriginalFilename();
        return qiniuService.uploadFile(file.getInputStream(), userId, filename);
    }
}
