package com.learn.zhaoyulearn.service.impl;

import com.learn.zhaoyulearn.dao.entity.User;
import com.learn.zhaoyulearn.dao.mapper.UserMapper;
import com.learn.zhaoyulearn.req.LoginUserReq;
import com.learn.zhaoyulearn.req.RegisterUserReq;
import com.learn.zhaoyulearn.service.UserService;
import com.learn.zhaoyulearn.vo.LoginUserVO;
import com.learn.zhaoyulearn.vo.RegisterUserVO;
import com.learn.zhaoyulearn.vo.TokenVO;
import com.learn.zhaoyulearn.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public RegisterUserVO register(RegisterUserReq param) {
        RegisterUserVO registerUserVO = new RegisterUserVO();

        if (param == null || !StringUtils.hasLength(param.getName()) || !StringUtils.hasLength(param.getPwd())) {
            registerUserVO.setIsSuccess(false);
            registerUserVO.setMessage("用户名或密码不存在");
            return registerUserVO;
        }

        User existingUser = userMapper.getByName(param.getName());
        if (existingUser != null) {
            registerUserVO.setIsSuccess(false);
            registerUserVO.setMessage("用户名已存在");
            return registerUserVO;
        }

        User user = new User();
        user.setUsername(param.getName());
        user.setPwd(param.getPwd());
        user.setToken(UUID.randomUUID().toString().replaceAll("-", ""));

        try {
            userMapper.insertUser(user);
        } catch (Exception e) {
            registerUserVO.setIsSuccess(false);
            return registerUserVO;
        }

        registerUserVO.setIsSuccess(true);
        registerUserVO.setMessage("注册成功");

        return registerUserVO;
    }

    @Override
    public LoginUserVO login(LoginUserReq param) {
        LoginUserVO loginUserVO = new LoginUserVO();

        if (param == null || !StringUtils.hasLength(param.getName()) || !StringUtils.hasLength(param.getPwd())) {
            loginUserVO.setIsSuccess(false);
            loginUserVO.setMessage("用户名或密码不能为空");
            return loginUserVO;
        }

        User user = userMapper.queryByName(param.getName());
        if (user == null || !user.getPwd().equals(param.getPwd())) {
            loginUserVO.setIsSuccess(false);
            loginUserVO.setMessage("用户名或密码错误");
            return loginUserVO;
        }

        loginUserVO.setIsSuccess(true);
        loginUserVO.setMessage("登录成功");
        loginUserVO.setToken(user.getToken());

        return loginUserVO;
    }

    @Override
    public List<UserVO> getUserList() {
        List<User> users = userMapper.queryAllUsers();

        List<UserVO> userVOList = new ArrayList<>();

        for (User user : users) {
            UserVO userVO = new UserVO();
            userVO.setUsername(user.getUsername());
            userVO.setId(user.getId());
            userVO.setPwd(user.getPwd());
            userVO.setToken(user.getToken());
            userVOList.add(userVO);
        }

        return userVOList;
    }

    @Override
    public TokenVO getTokenByUserName(String username) {
        User existingUser = userMapper.getByName(username);
        TokenVO result = new TokenVO();
        if (null != existingUser) {
            result.setToken(existingUser.getToken());
        }
        return result;
    }

}