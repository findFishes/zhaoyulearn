package com.learn.zhaoyulearn.controller;

import com.learn.zhaoyulearn.req.GetTokenByUserNameReq;
import com.learn.zhaoyulearn.req.LoginUserReq;
import com.learn.zhaoyulearn.req.RegisterUserReq;
import com.learn.zhaoyulearn.service.UserService;
import com.learn.zhaoyulearn.vo.LoginUserVO;
import com.learn.zhaoyulearn.vo.RegisterUserVO;
import com.learn.zhaoyulearn.vo.TokenVO;
import com.learn.zhaoyulearn.vo.UserVO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    @ResponseBody
    public RegisterUserVO register(@RequestBody RegisterUserReq param) {
        return userService.register(param);
    }



    @PostMapping("/login")
    @ResponseBody
    //public LoginUserVO login(@RequestBody LoginUserReq param, HttpSession session) {
    public LoginUserVO login(@RequestBody LoginUserReq param) {
        LoginUserVO loginUserVO = userService.login(param);
        if (loginUserVO.getIsSuccess()) {
            //session.setAttribute("user", param.getName());
        }
        return loginUserVO;
    }



    @GetMapping("/list")
    @ResponseBody
//    public List<UserVO> userList(HttpSession session) {
    public List<UserVO> userList() {
//        if (session.getAttribute("user") == null) {
//            throw new RuntimeException("请登录");
//        }
        return userService.getUserList();
    }


    @PostMapping("/getTokenByUserName")
    @ResponseBody
    public TokenVO getTokenByUserName(HttpServletRequest request, HttpServletResponse response, @RequestBody GetTokenByUserNameReq req) {
//        request.getSession();
//        request.getHeader();
//        request.getCookies();
//        request.getSession().setAttribute("userId", "");

        return userService.getTokenByUserName(req.getName());

    }



}
