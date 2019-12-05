package com.markdown.api.service;

import com.markdown.api.domain.ColorDO;
import com.markdown.api.mapper.ColorMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author lirui
 */
@Service
public class ColorService {

    @Resource
    private ColorMapper colorMapper;

    public List<ColorDO> getAll() {
        return colorMapper.selectAll();
    }

    public ColorDO getOne(Long id) {
        return colorMapper.selectOne(id);
    }

    public void insert(ColorDO color) {
        colorMapper.insert(color);
    }

    public void update(ColorDO color) {
        colorMapper.update(color);
    }


}
