package com.markdown.api.mapper;

import com.markdown.api.entity.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

/**
 * @author lirui
 */
@Component
public interface UserMapper {

    @Select("SELECT * FROM user")
    @Results({
            @Result(property = "id", column = "id", javaType = int.class),
            @Result(property = "githubId", column = "github_id", javaType = String.class),
            @Result(property = "wechat", column = "wechat", javaType = String.class),
            @Result(property = "wechatPlatform", column = "wechat_platform", javaType = String.class),
            @Result(property = "createTime", column = "create_time", javaType = Date.class),
            @Result(property = "updateTime", column = "update_time", javaType = Date.class)
    })
    /**
     * 查询
     * @return List<User>
     */
    List<User> getAll();

    @Select("SELECT * FROM user WHERE id = #{id}")
    @Results({
            @Result(property = "id", column = "id", javaType = int.class),
            @Result(property = "githubId", column = "github_id", javaType = String.class),
            @Result(property = "wechat", column = "wechat", javaType = String.class),
            @Result(property = "wechatPlatform", column = "wechat_platform", javaType = String.class),
            @Result(property = "createTime", column = "create_time", javaType = Date.class),
            @Result(property = "updateTime", column = "update_time", javaType = Date.class)
    })
    /**
     * 查询一条
     * @param id
     * @return User
     */
    User getOne(Integer id);

    @Insert("INSERT INTO user(githubId, wechat, wechatPlatform) VALUES(#{github_id}, #{wechat}, #{wechat_platform})")
    /**
     * 插入数据
     * @param user
     */
    void insert(User user);

    @Update("UPDATE user SET github_id=#{githubId}, wechat=#{wechat}, wechat_platform=#{wechatPlatform} WHERE id =#{id}")
    /**
     * 修改
     * @param user
     */
    void update(User user);

    @Delete("DELETE FROM user WHERE id =#{id}")
    /**
     * 删除
     * @param id
     */
    void delete(Integer id);
}
