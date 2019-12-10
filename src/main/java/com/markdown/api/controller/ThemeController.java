package com.markdown.api.controller;
import com.markdown.api.annotation.JwtIgnore;
import com.markdown.api.domain.ThemeDO;
import com.markdown.api.response.Result;
import com.markdown.api.service.ThemeService;
import com.markdown.api.vo.ThemeDetailVO;
import com.markdown.api.vo.ThemeVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;

/**
 * @author lirui
 */
@RestController
@EnableSwagger2
@Api(value = "theme", tags = "主题模块")
public class ThemeController {

    @Autowired
    private ThemeService themeService;

    @GetMapping("themes")
    @ApiOperation(value = "主题列表页接口")
    @JwtIgnore
    public Result<List<ThemeVO>> themeQueryAll() {
        //return themeService.getAll();
        return null;
    }

    @GetMapping("themes/{id}")
    @ApiOperation(value = "主题详情页接口")
    @JwtIgnore
    public Result<ThemeDetailVO> themeQueryOne(@PathVariable Long id) {
        //return  themeService.getOne(id);
        return null;
    }

    @PostMapping("themes/{themeId}/users/{userId}")
    @ApiOperation(value = "订阅接口")
    public Result subscribe(@PathVariable Long themeId, @PathVariable Long userId) {
        return Result.SUCCESS();
    }

    @GetMapping("themes/users/{userId}")
    @ApiOperation(value = "编辑器顶端二级下拉菜单接口")
    public Result<List<ThemeDetailVO>> queryThemeDetail(@PathVariable Long userId) {
        return null;
    }

    @PostMapping("themes")
    public void themeInsert(ThemeDO theme) {
        themeService.insert(theme);
    }

    @PutMapping("themes")
    public void themeUpdate(ThemeDO theme) {
        themeService.update(theme);
    }

}
