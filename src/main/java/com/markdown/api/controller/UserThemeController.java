package com.markdown.api.controller;
import com.markdown.api.entity.UserTheme;
import com.markdown.api.service.UserThemeService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import java.util.List;

@RestController
@EnableSwagger2
@Api(value = "userTheme", tags = "userThemeOperating")
@CrossOrigin(origins = "*", maxAge = 3600)
public class UserThemeController {

    @Autowired
    private UserThemeService userThemeService;

    @GetMapping("userThemes")
    public List<UserTheme> getAll() {
        return userThemeService.getAll();
    }

    @GetMapping("userThemes/{id}")
    public UserTheme getOne(@PathVariable Integer id) {
        return userThemeService.getOne(id);
    }

    @PostMapping("userThemes")
    public void insert(UserTheme userTheme) {
        userThemeService.insert(userTheme);
    }

    @PutMapping("userThemes")
    public void update(UserTheme userTheme) {
        userThemeService.update(userTheme);
    }
}
