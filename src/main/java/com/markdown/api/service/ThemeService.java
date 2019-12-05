package com.markdown.api.service;

import com.markdown.api.domain.ThemeDO;
import com.markdown.api.mapper.ThemeMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author lirui
 */
@Service
public class ThemeService {

    @Resource
    private ThemeMapper themeMapper;

    public List<ThemeDO> getAll() {
        return themeMapper.getAll();
    }

    public ThemeDO getOne(Long id) {
        return themeMapper.getOne(id);
    }

    public void insert(ThemeDO theme) {
        themeMapper.insert(theme);
    }

    public void update(ThemeDO theme) {
        themeMapper.update(theme);
    }
}
