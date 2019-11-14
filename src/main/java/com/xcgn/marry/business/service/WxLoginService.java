package com.xcgn.marry.business.service;

import com.alibaba.fastjson.JSONObject;

/**
 * create by ajaxgo on 2019/11/12
 **/
public interface WxLoginService {
    JSONObject weChatLogin(String code);
}
