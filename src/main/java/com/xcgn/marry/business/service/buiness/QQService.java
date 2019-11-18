package com.xcgn.marry.business.service.buiness;

import org.springframework.http.ResponseEntity;

/**
 * create by ajaxgo on 2019/11/18
 **/
public interface QQService {
    ResponseEntity qqLogin(Integer userId, String openId, String nickname, String headImgUrl);
}
