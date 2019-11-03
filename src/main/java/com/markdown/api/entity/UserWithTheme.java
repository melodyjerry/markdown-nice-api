package com.markdown.api.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author lirui
 */
@Data
public class UserWithTheme {

    private int id;

    private int use_id;

    private int theme_id;

    private Date create_time;

    private Date update_time;
}
