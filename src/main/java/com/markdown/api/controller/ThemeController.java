package com.markdown.api.controller;
import com.markdown.api.annotation.JwtIgnore;
import com.markdown.api.domain.ThemeDO;
import com.markdown.api.domain.UserThemeDO;
import com.markdown.api.response.Result;
import com.markdown.api.service.ThemeService;
import com.markdown.api.service.UserThemeService;
import com.markdown.api.vo.ThemeDetailVO;
import com.markdown.api.vo.ThemeVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * @author lirui
 */
@RestController
@EnableSwagger2
@Api(value = "theme", tags = "主题模块")
public class ThemeController {

    @Autowired
    private ThemeService themeService;

    @Autowired
    private UserThemeService userThemeService;

    @GetMapping("themes")
    @ApiOperation(value = "主题列表页接口")
    @JwtIgnore
    public Result<List<ThemeVO>> themeQueryAll(int start, int count) {
        List<ThemeVO> list = themeService.getAll(start, count);
        return Result.SUCCESS(list);
    }

    @GetMapping("themes/{id}")
    @ApiOperation(value = "主题详情页接口")
    @JwtIgnore
    public Result<ThemeDetailVO> themeQueryOne(@PathVariable Long id) {
        //return  themeService.getOne(id);
        ThemeDetailVO themeDetailVO = themeService.getOne(id);
        return Result.SUCCESS(themeDetailVO);
    }

    @PostMapping("themes/{themeId}/users/{userId}")
    @ApiOperation(value = "订阅接口")
    public Result subscribe(@PathVariable Long themeId, @PathVariable Long userId) {
        UserThemeDO userThemeDO = new UserThemeDO();
        userThemeDO.setThemeId(themeId);
        userThemeDO.setUserId(userId);
        userThemeService.insert(userThemeDO);
        return Result.SUCCESS();
    }

    @GetMapping("themes/users/{userId}")
    @ApiOperation(value = "编辑器顶端二级下拉菜单接口")
    public Result<List<ThemeDetailVO>> queryThemeDetail(@PathVariable Long userId) {
        List<ThemeDetailVO> themeDetailVOList = themeService.queryThemeDetailList(userId);
        return Result.SUCCESS(themeDetailVOList);
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
