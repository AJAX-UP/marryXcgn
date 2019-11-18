package com.xcgn.marry.business.service.buiness.serviceImpl;

import com.xcgn.marry.business.dao.business.BusinessUserMapper;
import com.xcgn.marry.business.model.business.BusinessUser;
import com.xcgn.marry.business.service.buiness.UserService;
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
@Service("businessUserService")
public class UserServiceImpl implements UserService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());


    @Autowired
    private BusinessUserMapper businessUserMapper;
    /**
     * description: 初始化用户
     * version: 1.0 
     * date: 2019/11/18 15:29 
     * author: ajaxgo
     * 
     * @param 
     * @return org.springframework.http.ResponseEntity
     */ 
    @Override
    public ResponseEntity initUser() {
        try {
            BusinessUser addUser=new BusinessUser();
            addUser.setCreateTime(new Date());
            int i =businessUserMapper.insertSelective(addUser);
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
