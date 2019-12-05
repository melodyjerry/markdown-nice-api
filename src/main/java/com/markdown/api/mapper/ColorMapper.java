package com.markdown.api.mapper;

import com.markdown.api.domain.ColorDO;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author lirui
 */
@Mapper
public interface ColorMapper {

    List<ColorDO> selectAll();

    ColorDO selectOne(@Param("id") Long id);

    void insert(ColorDO color);

    void update(ColorDO color);
}
