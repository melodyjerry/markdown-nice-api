package com.markdown.api.mapper;

import java.util.List;

import com.markdown.api.entity.Theme;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


/**
 * @author lirui
 */
@Mapper
public interface ThemeMapper {

    List<Theme> getAll();

    Theme getOne(@Param("id") Integer id);

    void insert(Theme theme);

    void update(Theme theme);

    void delete(Integer id);



}
