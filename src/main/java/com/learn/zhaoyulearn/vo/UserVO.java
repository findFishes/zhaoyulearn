package com.learn.zhaoyulearn.vo;

import lombok.Data;

@Data
public class UserVO {
    private String username;
    private Integer id;
    private String pwd;
    private String token;
}