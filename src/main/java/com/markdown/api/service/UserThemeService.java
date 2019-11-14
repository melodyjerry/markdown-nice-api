package com.markdown.api.service;

import com.markdown.api.entity.UserTheme;
import com.markdown.api.mapper.UserThemeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lirui
 */
@Service
public class UserThemeService {

    @Autowired
    private UserThemeMapper userThemeMapper;

    public List<UserTheme> getAll() {
        return userThemeMapper.getAll();
    }

    public UserTheme getOne(Integer id) {
        return userThemeMapper.getOne();
    }

    public void insert(UserTheme userTheme) {
        userThemeMapper.insert(userTheme);
    }

    public void update(UserTheme userTheme) {
        userThemeMapper.update(userTheme);
    }
}
