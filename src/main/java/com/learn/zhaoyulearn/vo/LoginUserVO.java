package com.learn.zhaoyulearn.vo;

import lombok.Data;

@Data
public class LoginUserVO {
    private Boolean isSuccess;
    private String message;
    private String token;
}