package com.markdown.api.controller;

import com.markdown.api.entity.Color;
import com.markdown.api.service.ColorService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import java.util.List;

@RestController
@EnableSwagger2
@Api(value = "color", tags = "colorOperating")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ColorController {

    @Autowired
    private ColorService colorService;

    @GetMapping("colors")
    public List<Color> getAll() {
        return colorService.getAll();
    }

    @GetMapping("colors/{id}")
    public Color getOne(@PathVariable Integer id) {
        return colorService.getOne(id);
    }

    @PostMapping("colors")
    public void insert(Color color) {
        colorService.insert(color);
    }

    @PutMapping("colors")
    public void update(Color color) {
        colorService.update(color);
    }
}
