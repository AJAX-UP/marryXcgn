package com.xcgn.marry.business.service.buiness;

import org.springframework.http.ResponseEntity;

/**
 * create by ajaxgo on 2019/11/18
 **/
public interface PhoneService {
    ResponseEntity phoneLogin(String phone, Integer userId);
}
