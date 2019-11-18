package com.xcgn.marry.business.controller.business;

import com.xcgn.marry.business.service.buiness.QQService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * create by ajaxgo on 2019/11/18
 **/
@Api("扣扣登录接口")
@RestController
@RequestMapping("app/qqlogin")
public class QQController {

    @Autowired
    private QQService qqService;

    @ApiOperation(value = "扣扣登录接口")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "userId",example = "-1", value = "用户的Id", required = true, dataType = "Int"),
            @ApiImplicitParam(paramType = "query", name = "openId", value = "QQ的openId", required = true, dataType = "String"),
            @ApiImplicitParam(paramType = "query", name = "nickname", value = "昵称", required = true, dataType = "String"),
            @ApiImplicitParam(paramType = "query", name = "headImgUrl", value = "头像", required = true, dataType = "String")
    })
    @PostMapping("/qqLogin")
    protected ResponseEntity qqLogin(@RequestParam Integer userId, @RequestParam String openId, @RequestParam String nickname, @RequestParam String headImgUrl) {
        return qqService.qqLogin(userId,openId,nickname,headImgUrl);
    }
}
