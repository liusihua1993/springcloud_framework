package com.mlink.controller;


import com.mlink.common.core.Result;
import com.mlink.common.core.ResultGenerator;
import com.mlink.entity.Material;
import com.mlink.service.MaterialService;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author LSH
 * @version 1.1
 * @date 2018/10/17
 * @Description
 */
@Api(value = "Material ", tags = {"Material"})
@RestController
@RequestMapping("Material")
public class MaterialController {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private MaterialService materialService;

    @ApiOperation(value = "添加Material实体")
    @ApiResponses({@ApiResponse(code = 200, message = "操作成功", response = Result.class)})
    @PostMapping("/add")
    public Result add(@ApiParam(value = "Material json对象") @RequestBody Material material) {
        logger.debug("----------------11111111111----------------");
        materialService.insert(material);
        return ResultGenerator.genSuccessResult();
    }


}
