package com.markdown.api.service;

import com.markdown.api.domain.ColorDO;
import com.markdown.api.mapper.ColorMapper;
import com.markdown.api.vo.ColorVO;
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

    public ColorVO toVO(ColorDO colorDO) {
        ColorVO colorVO = new ColorVO();
        colorVO.setAuthor(colorDO.getAuthor());
        colorVO.setCreateTime(colorDO.getCreateTime());
        colorVO.setCss(colorDO.getCss());
        colorVO.setId(colorDO.getId());
        colorVO.setLongPic(colorDO.getLongPic());
        colorVO.setThemeId(colorDO.getThemeId());
        colorVO.setUpdateTime(colorDO.getUpdateTime());
        return colorVO;
    }

}
