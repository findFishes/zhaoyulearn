package com.learn.zhaoyulearn.dao.entity;

import lombok.Data;

@Data
public class User {
    private Integer id;
    private String username;
    private String pwd;
    private String token;
}
