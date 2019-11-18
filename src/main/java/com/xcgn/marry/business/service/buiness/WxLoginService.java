package com.xcgn.marry.business.service.buiness;

import org.springframework.http.ResponseEntity;

/**
 * create by ajaxgo on 2019/11/12
 **/
public interface WxLoginService {
    /**
     * description: 授权登录
     * version: 1.0
     * date: 2019/11/18 11:09
     * author: ajaxgo
     *
     * @param code
     * @return com.xcgn.marry.business.utils.HttpResponse
     */
    ResponseEntity weChatLogin(Integer userId, String code);

    /**
     * description: 绑定微信
     * version: 1.0
     * date: 2019/11/18 11:10
     * author: ajaxgo
     *
     * @param code
 * @param userId
     * @return
     */
    ResponseEntity bindWeChat(String code,Integer userId);
}
