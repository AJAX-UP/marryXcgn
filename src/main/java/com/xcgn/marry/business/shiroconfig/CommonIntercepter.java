package com.xcgn.marry.business.shiroconfig;

import com.alibaba.fastjson.JSON;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.mybatis.logging.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

@Component
public class CommonIntercepter implements HandlerInterceptor {


    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {
        //允许跨域,不能放在postHandle内
        response.setHeader("Access-Control-Allow-Origin", "*");
        if (request.getMethod().equals("OPTIONS")) {
            response.addHeader("Access-Control-Allow-Methods", "GET,HEAD,POST,PUT,DELETE,TRACE,OPTIONS,PATCH");
            response.addHeader("Access-Control-Allow-Headers", "Content-Type, Accept, Authorization");
        }
        return true;
    }
}