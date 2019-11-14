package com.xcgn.marry.business.controller;

import com.alibaba.fastjson.JSONObject;
import com.xcgn.marry.business.service.WxLoginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * create by ajaxgo on 2019/11/12
 **/
@Api("微信登录接口")
@RestController
@RequestMapping("/wxlogin")
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
            @ApiImplicitParam(paramType = "query", name = "code", value = "用户换取access_token的code，仅在ErrCode为0时有效", required = true, dataType = "String")
    })
    @GetMapping("/weChatLogin")
    protected JSONObject weChatLogin(@RequestParam String code) {
        return wxLoginService.weChatLogin(code);
    }
}
