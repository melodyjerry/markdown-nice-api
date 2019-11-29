package com.markdown.api.mapper;

import com.markdown.api.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author lirui
 */
@Mapper
public interface UserMapper {

    List<User> getAll();

    User getOne(Integer id);

    User getOneByParam(@Param("username") String username);

    User getOneByGitid(@Param("githubId") String githubId);

    void insert(User user);

    void update(User user);

    void delete(Integer id);


}
