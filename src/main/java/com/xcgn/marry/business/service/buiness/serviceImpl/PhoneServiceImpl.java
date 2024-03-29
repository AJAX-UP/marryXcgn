package com.xcgn.marry.business.service.buiness.serviceImpl;

import com.xcgn.marry.business.dao.business.BusinessUserMapper;
import com.xcgn.marry.business.model.business.BusinessUser;
import com.xcgn.marry.business.service.buiness.PhoneService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * create by ajaxgo on 2019/11/18
 **/
@Service("phoneService")
public class PhoneServiceImpl implements PhoneService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private BusinessUserMapper businessUserMapper;
    /**
     * description: 手机号登录
     * version: 1.0 
     * date: 2019/11/18 14:56 
     * author: ajaxgo
     * 
     * @param phone
 * @param userId
     * @return org.springframework.http.ResponseEntity
     */ 
    @Override
    public ResponseEntity phoneLogin(String phone, Integer userId) {
        try {
            BusinessUser addUser=new BusinessUser();
            addUser.setPhone(phone);
            addUser.setId(userId);
            addUser.setCreateTime(new Date());
            int i =businessUserMapper.updateByPrimaryKeySelective(addUser);
            if(i!=0){
                return  new ResponseEntity<>(addUser, HttpStatus.OK);
            }else{
                return  new ResponseEntity<>(addUser, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }catch (Exception e){
           logger.error(e.getMessage());
           return  new ResponseEntity<>("未知错误", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
