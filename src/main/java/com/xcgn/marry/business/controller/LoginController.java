package com.xcgn.marry.business.controller;

import com.alibaba.fastjson.JSONObject;
import com.xcgn.marry.business.model.User;
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
import org.springframework.web.bind.annotation.*;

@Api("客服接口")
@RestController
@RequestMapping("/login")
public class LoginController {


    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    /**
     * 登录方法
     * @param userInfo
     * @return
     */
    @ApiOperation(value="测试接口api", notes="根据cid获取客服信息，this is test api")
    @PostMapping("/ajaxLogin")
    public String ajaxLogin(User userInfo) {
        JSONObject jsonObject = new JSONObject();
        Subject subject = SecurityUtils.getSubject();
        logger.error("当前为日志测试");
        UsernamePasswordToken token = new UsernamePasswordToken(userInfo.getUsername(), userInfo.getPassword());
        try {
            subject.login(token);
            jsonObject.put("token", subject.getSession().getId());
            jsonObject.put("msg", "登录成功");
        } catch (IncorrectCredentialsException e) {
            jsonObject.put("msg", "密码错误");
        } catch (LockedAccountException e) {
            jsonObject.put("msg", "登录失败，该用户已被冻结");
        } catch (AuthenticationException e) {
            jsonObject.put("msg", "该用户不存在");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonObject.toString();
    }

    @ApiOperation(value="测试接口", notes="获取客服信息")
    @PostMapping("/selectUser")
    public String selectUser() {
        System.out.println("123");
        return "123";
    }
}
