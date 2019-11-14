package com.markdown.api.mapper;

import com.markdown.api.entity.Color;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;
import java.util.Date;
import java.util.List;

/**
 * @author lirui
 */
@Mapper
public interface ColorMapper {

    List<Color> selectAll();

    Color selectOne(@Param("id") Integer id);

    void insert(Color color);

    void update(Color color);
}
