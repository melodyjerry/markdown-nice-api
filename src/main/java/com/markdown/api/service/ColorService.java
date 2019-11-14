package com.markdown.api.service;

import com.markdown.api.entity.Color;
import com.markdown.api.mapper.ColorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lirui
 */
@Service
public class ColorService {

    @Autowired
    private ColorMapper colorMapper;

    public List<Color> getAll() {
        return colorMapper.selectAll();
    }

    public Color getOne(Integer id) {
        return colorMapper.selectOne(id);
    }

    public void insert(Color color) {
        colorMapper.insert(color);
    }

    public void update(Color color) {
        colorMapper.update(color);
    }


}
