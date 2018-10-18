package com.mlink.service;


import com.mlink.entity.User;
import com.mlink.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author lsh
 * @date 2018/10/15
 * 注:  需要回归接口添加 注解 ：@Transactional(rollbackFor = Exception.class)
 */


@Service
@EnableTransactionManagement
public class UserService  {
    @Autowired(required = false)
    private UserMapper userMapper;

    public User selectByPhone(String phone) {
        return userMapper.selectByPhone(phone);
    }

    @Transactional(rollbackFor = Exception.class)
    public void insert(User user) {
        userMapper.insert(user);
    }
}


