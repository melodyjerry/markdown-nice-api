package com.markdown.api.controller;

import com.markdown.api.entity.Theme;
import com.markdown.api.service.ThemeService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;

/**
 * @author lirui
 */
@RestController
@EnableSwagger2
@Api(value = "theme", tags = "themeOperating")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ThemeController {

    @Autowired
    private ThemeService themeService;

    @GetMapping("themes")
    public List<Theme> themeQueryAll() {
        return themeService.getAll();
    }

    @GetMapping("themes/id")
    public Theme themeQueryOne(Integer id) {
        return  themeService.getOne(id);
    }

    @PostMapping("themes")
    public void themeInsert(Theme theme) {
        themeService.insert(theme);
    }

    @PutMapping("themes/id")
    public void themeUpdate(Theme theme) {
        themeService.update(theme);
    }
}
