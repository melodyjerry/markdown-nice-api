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

    UserThemeDO getOne(Long id);

    void insert(UserThemeDO userTheme);

    void update(UserThemeDO userTheme);
}
