package com.mlink.service.client;

import com.mlink.entity.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author LSH
 * @version 1.1
 * @date 2018/10/15
 * @Description
 */
@FeignClient(name = "user-service",fallback = UserClient.UserClientFallback.class)
public interface UserClient {

    /**
     * feign 调用根据手机号获取用户
     * @param phone
     * @return
     */
    @GetMapping(value = "/getUserByPhone")
    User getUserByPhone(@RequestParam(value = "phone") String phone);

    @Component
     class UserClientFallback implements UserClient {
        @Override
        public User getUserByPhone(String phone) {
            System.out.println("连接超时++++++");
            return new User();
        }
    }

}
