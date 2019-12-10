package com.markdown.api.controller;
import com.markdown.api.domain.UserThemeDO;
import com.markdown.api.service.UserThemeService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import java.util.List;

@ApiIgnore
@RestController
//@EnableSwagger2
@Api(value = "userTheme", tags = "用户&&主题")
public class UserThemeController {

    @Autowired
    private UserThemeService userThemeService;

    @GetMapping("userThemes")
    public List<UserThemeDO> getAll() {
        return userThemeService.getAll();
    }

    @GetMapping("userThemes/{id}")
    public UserThemeDO getOne(@PathVariable Long id) {
        return userThemeService.getOne(id);
    }

    @PostMapping("userThemes")
    public void insert(UserThemeDO userTheme) {
        userThemeService.insert(userTheme);
    }

    @PutMapping("userThemes")
    public void update(UserThemeDO userTheme) {
        userThemeService.update(userTheme);
    }
}
