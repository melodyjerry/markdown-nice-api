package com.markdown.api.mapper;

import com.markdown.api.domain.UserDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author lirui
 */
@Mapper
public interface UserMapper {

    List<UserDO> getAll();

    UserDO getOne(@Param("id") Long id);

    UserDO getOneByUsername(@Param("username") String username);

    UserDO getOneByGitId(@Param("githubId") String githubId);

    Long insert(UserDO userDO);

    void update(UserDO user);

    void delete(Long id);


}
