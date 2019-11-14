package com.markdown.api.mapper;

import com.markdown.api.entity.UserTheme;
import org.apache.ibatis.annotations.*;
import java.util.List;

/**
 * @author lirui
 */
@Mapper
public interface UserThemeMapper {

    List<UserTheme> getAll();

    UserTheme getOne(Integer id);

    void insert(UserTheme userTheme);

    void update(UserTheme userTheme);
}
