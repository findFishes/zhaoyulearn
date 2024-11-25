package com.learn.zhaoyulearn.service;

import com.learn.zhaoyulearn.req.LoginUserReq;
import com.learn.zhaoyulearn.req.RegisterUserReq;
import com.learn.zhaoyulearn.vo.LoginUserVO;
import com.learn.zhaoyulearn.vo.RegisterUserVO;
import com.learn.zhaoyulearn.vo.TokenVO;
import com.learn.zhaoyulearn.vo.UserVO;

import java.util.List;

public interface UserService {
    RegisterUserVO register(RegisterUserReq param);
    LoginUserVO login(LoginUserReq param);
    List<UserVO> getUserList();

    TokenVO getTokenByUserName(String username);
}
