package com.markdown.api.mapper;

import com.markdown.api.entity.User;
import org.apache.ibatis.annotations.*;
import java.util.List;

/**
 * @author lirui
 */
@Mapper
public interface UserMapper {

    List<User> getAll();

    User getOne(@Param("id") Integer id);

    void insert(User user);

    void update(User user);

    void delete(Integer id);
}
