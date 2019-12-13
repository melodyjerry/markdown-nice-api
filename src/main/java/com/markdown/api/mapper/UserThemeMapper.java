package com.markdown.api.mapper;

import com.markdown.api.domain.UserThemeDO;
import org.apache.ibatis.annotations.*;
import java.util.List;

/**
 * @author lirui
 */
@Mapper
public interface UserThemeMapper {

    List<UserThemeDO> getAll();

    UserThemeDO getOne(@Param("id") Long id);

    void insert(UserThemeDO userTheme);

    void update(UserThemeDO userTheme);

    List<UserThemeDO> queryListByUserId(@Param("userId") Long userId);
}
