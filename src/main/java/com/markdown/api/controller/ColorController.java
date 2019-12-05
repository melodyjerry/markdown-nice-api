package com.markdown.api.controller;

import com.markdown.api.domain.ColorDO;
import com.markdown.api.service.ColorService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author lirui
 */
@ApiIgnore
@RestController
//@EnableSwagger2
@Api(value = "color", tags = "主题颜色")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ColorController {

    @Resource
    private ColorService colorService;

    @GetMapping("colors")
    public List<ColorDO> getAll() {
        return colorService.getAll();
    }

    @GetMapping("colors/{id}")
    public ColorDO getOne(@PathVariable Long id) {
        return colorService.getOne(id);
    }

    @PostMapping("colors")
    public void insert(ColorDO color) {
        colorService.insert(color);
    }

    @PutMapping("colors")
    public void update(ColorDO color) {
        colorService.update(color);
    }
}
