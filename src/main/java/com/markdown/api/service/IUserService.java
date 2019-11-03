package com.markdown.api.service;

import com.markdown.api.entity.User;

import java.util.List;

/**
 * @author lirui
 */
public interface IUserService {

    List<User> userQuery();
}
