package com.xcgn.marry.business.admin;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Api("客服接口")
@Controller
@RequestMapping("/login")
public class LoginController {

    @ApiOperation(value="测试接口api", notes="根据cid获取客服信息，this is test api")
    @ApiImplicitParam(name = "cid", value = "客户id", required = true, dataType = "String")
    @ResponseBody
    @PostMapping("/getCenter")
    public String getCinterCall(@PathVariable String cid) {

        return "";
    }
}
