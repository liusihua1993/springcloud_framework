package com.mlink.controller;


import com.mlink.common.core.Result;
import com.mlink.common.core.ResultGenerator;
import com.mlink.entity.User;
import com.mlink.service.UserService;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
* Created by fudazhi on 2018/10/15.
*/
@Api(value="User ",tags={"User"})
@RestController
@RequestMapping("User")
public class UserController {
    
     Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserService userService;

    @ApiOperation(value = "添加User实体")
    @ApiResponses({ @ApiResponse(code = 200, message = "操作成功", response=Result.class)})
    @PostMapping("/add")
    public Result add(@ApiParam(value="User json对象") @RequestBody User user) {
        userService.insert(user);
        return ResultGenerator.genSuccessResult();
    }

}
