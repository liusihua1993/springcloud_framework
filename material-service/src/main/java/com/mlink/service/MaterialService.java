package com.mlink.service;


import com.mlink.common.utils.Utils;
import com.mlink.entity.Material;
import com.mlink.entity.User;
import com.mlink.mapper.MaterialMapper;
import com.mlink.service.client.UserClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by fudazhi on 2018/10/15.
 * 注:  需要回归接口添加 注解 ：@Transactional(rollbackFor = Exception.class)
 */


@Service
@EnableTransactionManagement
public class MaterialService  {
    @Autowired(required = false)
    private MaterialMapper mapper;

    @Autowired
    private UserClient userClient;

    public void insert(Material material) {
        String phone = "17610271025";
        User user = userClient.getUserByPhone(phone);
        material.setCreateUser(user.getUserId());
        material.setMaterialId(Utils.getUUID());
        mapper.insert(material);
    }
}


