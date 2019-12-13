package com.markdown.api.service;

import com.markdown.api.domain.UserThemeDO;
import com.markdown.api.mapper.UserThemeMapper;
import com.markdown.api.vo.ThemeDetailVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author lirui
 */
@Service
public class UserThemeService {

    @Resource
    private UserThemeMapper userThemeMapper;

    public List<UserThemeDO> getAll() {
        return userThemeMapper.getAll();
    }

    public UserThemeDO getOne(Long id) {
        return userThemeMapper.getOne(id);
    }

    public void insert(UserThemeDO userTheme) {
        userThemeMapper.insert(userTheme);
    }

    public void update(UserThemeDO userTheme) {
        userThemeMapper.update(userTheme);
    }

}
