package com.macrun.emagazine.dto;

import lombok.Data;

@Data
public class PostDto {
    private long id;
    private int category;
    private String title;
    private String post_content;
    private int asset;
    private UserDto user;
}
