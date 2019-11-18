package com.xcgn.marry.business.controller.business;

import com.xcgn.marry.business.service.buiness.PhoneService;
import com.xcgn.marry.business.service.buiness.RedisService;
import com.xcgn.marry.business.utils.sms.XUSmsUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * create by ajaxgo on 2019/11/18
 **/
@Api("手机号登录接口")
@RestController
@RequestMapping("app/phonelogin")
public class PhoneController {

    @Autowired
    private RedisService redisService;

    @Autowired
    private PhoneService phoneService;

    @ApiOperation("获取手机验证码")
    @PostMapping(value = "/getCode")
    public ResponseEntity getCode(@RequestParam @ApiParam(name = "phone", value = "手机号") String phone,
                                  HttpServletRequest request){
        return new ResponseEntity<>(XUSmsUtils.getSms(phone,"【嗨用呗】",redisService), HttpStatus.OK);
    }
    @ApiOperation("app手机登录")
    @PostMapping(value = "/phoneLogin")
    public ResponseEntity phoneLogin(@RequestParam @ApiParam(name = "phone", value = "手机号") String phone,
                                     @RequestParam @ApiParam(name = "userId", value = "用户Id",example = "-1") Integer userId,
                                   @RequestParam @ApiParam(name = "code", value = "验证码") String code,
                                   HttpServletRequest request)  {
        Map<String, Object> map = new HashMap<>();
        String redisCode =redisService.getCodeVal(phone);
        if (StringUtils.isEmpty(redisCode)) {
            return new ResponseEntity<>("验证码已过期",HttpStatus.UNAUTHORIZED);
        }
        if(!code.equals(redisCode)){
            return new ResponseEntity<>("验证码错误",HttpStatus.UNAUTHORIZED);
        }
        if(!"".equals(redisCode)&&code.equals(redisCode)&&null!=redisCode){
            return phoneService.phoneLogin(phone,userId);
        }else{
            return new ResponseEntity<>("未知错误",HttpStatus.UNAUTHORIZED);
        }
    }
}
