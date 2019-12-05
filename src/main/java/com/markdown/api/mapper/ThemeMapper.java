package com.markdown.api.mapper;

import java.util.List;

import com.markdown.api.domain.ThemeDO;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


/**
 * @author lirui
 */
@Mapper
public interface ThemeMapper {

    List<ThemeDO> getAll();

    ThemeDO getOne(@Param("id") Long id);

    void insert(ThemeDO theme);

    void update(ThemeDO theme);

    void delete(Integer id);



}
