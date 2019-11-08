package com.xcgn.marry.business.admin;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Api("客服接口")
@RestController
@RequestMapping("/login")
public class LoginController {

    @ApiOperation(value="测试接口api", notes="根据cid获取客服信息，this is test api")
    @ApiImplicitParam(name = "cid", value = "客户id", required = true, dataType = "String")
    @PostMapping("/getCenter")
    public String getCinterCall(String cid) {

        return "";
    }
}
