package com.learn.zhaoyulearn.dao.impl;

import com.learn.zhaoyulearn.dao.UserDao;
import com.learn.zhaoyulearn.dao.entity.User;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class UserDaoImpl implements UserDao {

    private List<User> userList = new ArrayList<>();

    private final AtomicLong idFactory = new AtomicLong(0L);


    @Override
    public void save(User user) {
        if (null == user || !StringUtils.hasLength(user.getUsername()) || !StringUtils.hasLength(user.getPwd())) {
            throw new RuntimeException("用户名或密码不能为空");
        }

        User userRecord = getByName(user.getUsername());

        if (null != userRecord) {
            throw new RuntimeException("用户已存在");
        }

        user.setId((int) idFactory.incrementAndGet());
        userList.add(user);
    }

    @Override
    public int update(User user) {
        User userRecord = getByName(user.getUsername());
        if (null == userRecord) {
            return 0;
        }

        if (StringUtils.hasLength(user.getPwd())) {
            userRecord.setPwd(user.getPwd());
        }
        if (StringUtils.hasLength(user.getToken())) {
            userRecord.setToken(user.getToken());
        }
        return 1;
    }

    @Override
    public int delete(Long id) {
        int count = 0;

        for (int i = 0; i < userList.size(); i++) {
            if (userList.get(i).getId().equals(id)) {
                userList.remove(i);
                count++;
                break;
            }
        }
        return count;
    }

    @Override
    public User queryByName(String name) {
        if (!StringUtils.hasLength(name)) {
            return null;
        }
        for (User each : userList) {
            if (each.getUsername().equals(name)) {
                return each;
            }
        }
        return null;
    }

    @Override
    public User queryByToken(String token) {
        if (!StringUtils.hasLength(token)) {
            return null;
        }
        for (User each : userList) {
            if (each.getToken().equals(token)) {
                return each;
            }
        }
        return null;
    }


    private User getByName(String name) {
        if (!StringUtils.hasLength(name)) {
            return null;
        }
        for (User each : userList) {
            if (each.getUsername().equals(name)) {
                return each;
            }
        }
        return null;
    }

    private User getById(Long id) {
        if (null == id) {
            return null;
        }
        for (User each : userList) {
            if (each.getId().equals(id)) {
                return each;
            }
        }
        return null;
    }

    private User getByToken(String token) {
        if (!StringUtils.hasLength(token)) {
            return null;
        }
        for (User each : userList) {
            if (each.getToken().equals(token)) {
                return each;
            }
        }
        return null;
    }
}
