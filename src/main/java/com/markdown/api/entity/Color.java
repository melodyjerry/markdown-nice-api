package com.markdown.api.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author lirui
 */
@Data
public class Color {

    private int id;

    private int theme_id;

    private String css;

    private String long_pic;

    private String author;

    private Date create_time;

    private Date update_time;
}
