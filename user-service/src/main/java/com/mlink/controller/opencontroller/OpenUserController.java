package com.mlink.controller.opencontroller;


import com.mlink.entity.User;
import com.mlink.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author LSH
 * @version 1.1
 * @date 2018/10/15
 * @Description
 */
@RestController
public class OpenUserController {

    @Autowired
    private UserService userService;

    @GetMapping("/getUserByPhone")
    public User detail(@RequestParam String phone) throws InterruptedException {
      return userService.selectByPhone(phone);
    }

}
