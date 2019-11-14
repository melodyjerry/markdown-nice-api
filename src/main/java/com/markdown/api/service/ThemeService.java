package com.markdown.api.service;

import com.markdown.api.entity.Theme;
import com.markdown.api.mapper.ThemeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lirui
 */
@Service
public class ThemeService {

    @Autowired
    private ThemeMapper themeMapper;

    public List<Theme> getAll() {
        return themeMapper.getAll();
    }

    public Theme getOne(Integer id) {
        return themeMapper.getOne(id);
    }

    public void insert(Theme theme) {
        themeMapper.insert(theme);
    }

    public void update(Theme theme) {
        themeMapper.update(theme);
    }
}
