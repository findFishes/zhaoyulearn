package com.learn.zhaoyulearn.dao;

import com.learn.zhaoyulearn.dao.entity.User;

public interface UserDao {
    void save(User user);

    int update(User user);

    int delete(Long id);

    User queryByName(String name);

    User queryByToken(String token);


}
