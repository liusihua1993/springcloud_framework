package com.mlink.mapper;


import com.mlink.entity.User;

/**
 * @author LSH
 * @version 1.1
 * @date 2018/9/27
 * @Description
 */

public interface UserMapper {

    User getUserByPhoneForOauth(String username);

}
