package com.xcgn.marry.business.controller.business;

import com.xcgn.marry.business.service.buiness.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * create by ajaxgo on 2019/11/18
 **/
@Api(tags ="用户相关接口")
@RestController
@RequestMapping("app/user")
public class UserController {

    @Autowired
    private UserService businessUserService;

    @ApiOperation(value = "初始化用户")
    @PostMapping("/initUser")
    protected ResponseEntity initUser() {
        return businessUserService.initUser();
    }

    @ApiOperation(value = "获取用户基本信息")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query",example = "-1", name = "userId", value = "userId", required = true, dataType = "Int")})
    @PostMapping("/selectUser")
    protected ResponseEntity selectUser(@RequestParam Integer userId) {

        return businessUserService.selectUser(userId);
    }

    @ApiOperation(value = "获取用户排行榜")
    @PostMapping("/selectUserRank")
    protected ResponseEntity selectUserRank() {
        return businessUserService.selectUserRank();
    }

}
