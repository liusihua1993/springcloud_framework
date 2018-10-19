package com.mlink.service;


import com.mlink.common.utils.Utils;
import com.mlink.entity.Material;
import com.mlink.entity.User;
import com.mlink.mapper.MaterialMapper;
import com.mlink.service.client.UserClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author LSH
 * @version 1.1
 * @date 2018/10/17
 * @Description
 */
@Service
@EnableTransactionManagement
public class MaterialService  {
    @Autowired(required = false)
    private MaterialMapper mapper;

    @Autowired
    private UserClient userClient;

    @Transactional(rollbackFor = Exception.class)
    public void insert(Material material) {
        String phone = "17610271025";
        User user = userClient.getUserByPhone(phone);
        material.setCreateUser(user.getUserId());
        material.setMaterialId(Utils.getUUID());
        mapper.insert(material);
    }
}


