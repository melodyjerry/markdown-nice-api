package com.markdown.api.service;

import com.markdown.api.domain.ColorDO;
import com.markdown.api.domain.ThemeDO;
import com.markdown.api.domain.UserThemeDO;
import com.markdown.api.mapper.ColorMapper;
import com.markdown.api.mapper.ThemeMapper;
import com.markdown.api.mapper.UserThemeMapper;
import com.markdown.api.util.Page;
import com.markdown.api.vo.ColorVO;
import com.markdown.api.vo.ThemeDetailVO;
import com.markdown.api.vo.ThemeVO;
import org.springframework.stereotype.Service;
import org.springframework.ui.context.Theme;

import javax.annotation.Resource;
import java.util.*;

/**
 * @author lirui
 */
@Service
public class ThemeService {

    @Resource
    private ThemeMapper themeMapper;

    @Resource
    private ColorMapper colorMapper;

    @Resource
    private ColorService colorService;

    @Resource
    private UserThemeMapper userThemeMapper;

    public List<ThemeVO> getAll(int start, int count) {
        //Page page = new Page(start, count);
        List<ThemeDO> listThemeDO = themeMapper.getAll(start, count);
        List<ThemeVO> listThemeVO = new ArrayList<ThemeVO>();
        for(int i = 0; i < listThemeDO.size(); i++) {
            listThemeVO.add(toThemeVO(listThemeDO.get(i)));
        }
        return listThemeVO;
    }

    public ThemeDetailVO getOne(Long id) {
        ThemeDO themeDO = themeMapper.getOne(id);
        List<ColorDO> colorList = colorMapper.getListByThemeId(id);
        List<ColorVO> colorVOList = new ArrayList<>();
        for(int i = 0; i < colorList.size(); i++) {
            colorVOList.add(colorService.toVO(colorList.get(i)));
        }
        ThemeDetailVO themeDetailVO = toThemeDetailVO(themeDO);
        themeDetailVO.setColorList(colorVOList);
        return themeDetailVO;
    }

    public List<ThemeDetailVO> queryThemeDetailList(Long userId) {
        List<UserThemeDO> userThemeDOS = userThemeMapper.queryListByUserId(userId);
        List<ThemeDetailVO> themeDetailVOS = new ArrayList<>();
        long themeId;
        for(int i = 0; i < userThemeDOS.size(); i++) {
            themeId = userThemeDOS.get(i).getThemeId();
            //themeVOS.add(toThemeVO(themeMapper.getOne(themeId)));
            themeDetailVOS.add(this.getOne(themeId));
        }
        return themeDetailVOS;
    }

    public void insert(ThemeDO theme) {
        themeMapper.insert(theme);
    }

    public void update(ThemeDO theme) {
        themeMapper.update(theme);
    }

    private ThemeVO toThemeVO(ThemeDO themeDO) {
        ThemeVO themeVO = new ThemeVO();
        themeVO.setId(themeDO.getId());
        themeVO.setName(themeDO.getName());
        themeVO.setCreateTime(themeDO.getCreateTime());
        themeVO.setEnglishName(themeDO.getEnglishName());
        themeVO.setUpdateTime(themeDO.getUpdateTime());
        themeVO.setScreenshot(themeDO.getScreenshot());
        themeVO.setQrCode(themeDO.getQrCode());
        themeVO.setAuthor(themeDO.getAuthor());
        themeVO.setDescription(themeDO.getDescription());
        return themeVO;
    }

    private ThemeDetailVO toThemeDetailVO(ThemeDO themeDO) {
        ThemeDetailVO themeDetailVO = new ThemeDetailVO();
        themeDetailVO.setId(themeDO.getId());
        themeDetailVO.setName(themeDO.getName());
        themeDetailVO.setCreateTime(themeDO.getCreateTime());
        themeDetailVO.setEnglishName(themeDO.getEnglishName());
        themeDetailVO.setUpdateTime(themeDO.getUpdateTime());
        themeDetailVO.setScreenshot(themeDO.getScreenshot());
        themeDetailVO.setQrCode(themeDO.getQrCode());
        themeDetailVO.setAuthor(themeDO.getAuthor());
        themeDetailVO.setDescription(themeDO.getDescription());
        return themeDetailVO;
    }

}
