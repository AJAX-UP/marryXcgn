package com.xcgn.marry.business.controller;

import com.alibaba.fastjson.JSONObject;
import com.xcgn.marry.business.model.User;
import com.xcgn.marry.business.utils.sms.XUSmsUtils;
import com.xcgn.marry.business.utils.wxzf.WechatpayUtil;
import com.xcgn.marry.business.utils.wxzf.entity.ResultEntity;
import com.xcgn.marry.business.utils.wxzf.entity.TransfersDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@Api("客服接口")
@RestController
@RequestMapping("/login")
public class LoginController {


    private final Logger logger = LoggerFactory.getLogger(this.getClass());


    @Autowired
    private TransfersDto model;

//    @ApiOperation(value="测试接口api", notes="根据cid获取客服信息，this is test api")
//    @PostMapping("/ajaxLogin")
//    public String ajaxLogin(User userInfo) {
//        JSONObject jsonObject = new JSONObject();
//        Subject subject = SecurityUtils.getSubject();
//        logger.error("当前为日志测试");
//        UsernamePasswordToken token = new UsernamePasswordToken(userInfo.getUsername(), userInfo.getPassword());
//        try {
//            subject.login(token);
//
//            Subject sub = SecurityUtils.getSubject();
//            Object obj = sub.getPrincipal();
//            jsonObject.put("token", subject.getSession().getId());
//            jsonObject.put("msg", "登录成功");
//        } catch (IncorrectCredentialsException e) {
//            jsonObject.put("msg", "密码错误");
//        } catch (LockedAccountException e) {
//            jsonObject.put("msg", "登录失败，该用户已被冻结");
//        } catch (AuthenticationException e) {
//            jsonObject.put("msg", "该用户不存在");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return jsonObject.toString();
//    }

    //微信付款
    @ApiOperation(value="测试接口", notes="获取客服信息")
    @PostMapping("/selectUser")
    public String selectUser() {
        System.out.println(model);
        return model.getMch_name();
//        String appkey = "BUSHULEZHUANbushulezhuan12345678";// 微信商户秘钥, 根据实际情况填写
//        String certPath = "/usr/local/web_app/wxAPP/bsllz.p12";// 微信商户证书路径, 根据实际情况填写
//        TransfersDto model = new TransfersDto();// 微信接口请求参数, 根据实际情况填写
//        model.setMch_appid("wx371c1269ca692376"); // 申请商户号的appid或商户号绑定的appid
//        model.setMchid("1551970781"); // 商户号
//        model.setMch_name("星辰光年商户号"); // 商户名称
//        model.setOpenid("oyICL5TcBR4xSPf0BXRSuCxmOu4o"); // 商户appid下，某用户的openid
//        model.setAmount(1); // 企业付款金额，这里单位为元
//        model.setDesc("测试企业付款到零钱");
//        // 微信官方API文档 https://pay.weixin.qq.com/wiki/doc/api/tools/mch_pay.php?chapter=14_2
//        ResultEntity iResult = WechatpayUtil.doTransfers(appkey, certPath, model);
//        return iResult.toString();
    }
}
