package com.xcgn.marry.business.controller.business;

import com.xcgn.marry.business.service.buiness.WxLoginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * create by ajaxgo on 2019/11/12
 **/
@Api(tags = {"微信相关接口"})
@RestController
@RequestMapping("app/wxlogin")
public class WxController {

    @Autowired
    private WxLoginService wxLoginService;
    /**
     * @throws
     * @title weChatLogin
     * @description 微信授权登录
     * @author ajaxgo
     * @updateTime 2019-9-12 16:00:51
     */
    @ApiOperation(value = "微信授权登录")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query",example = "-1", name = "userId", value = "userId", required = true, dataType = "Int"),
            @ApiImplicitParam(paramType = "query", name = "code", value = "用户换取access_token的code，仅在ErrCode为0时有效", required = true, dataType = "String")
    })
    @PostMapping("/weChatLogin")
    protected ResponseEntity weChatLogin(@RequestParam Integer userId, @RequestParam String code) {
        return wxLoginService.weChatLogin(userId,code);
    }

    /**
     * description: 绑定微信
     * version: 1.0 
     * date: 2019/11/18 11:36
     * author: ajaxgo
     * 
     * @param code
 * @param userId
     * @return com.xcgn.marry.business.utils.HttpResponse
     */ 
    @ApiOperation(value = "绑定微信")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "code", value = "用户换取access_token的code，仅在ErrCode为0时有效", required = true, dataType = "String"),
            @ApiImplicitParam(paramType = "query",example = "-1", name = "userId", value = "需要绑定的用户", required = true, dataType = "Int")

    })
    @PostMapping("/bindWeChat")
    protected ResponseEntity bindWeChat(@RequestParam String code,@RequestParam Integer userId) {
        return wxLoginService.bindWeChat(code,userId);
    }
}
