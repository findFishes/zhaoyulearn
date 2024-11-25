package com.learn.zhaoyulearn.dao.mapper;

import com.learn.zhaoyulearn.dao.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface UserMapper {
    User queryByName(String username);
    void insertUser(User user);
    void updateUser(User user);
    void deleteUser(String username);
    User queryByToken(String token);
    User getByName(String username);
    User getById(Long id);
    User getByToken(String token);
    List<User> queryAllUsers();

    User queryTokenByUserame (String username);
}