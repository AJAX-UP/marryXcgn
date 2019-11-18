package com.xcgn.marry.business.service.buiness.serviceImpl;

import com.xcgn.marry.business.dao.business.BusinessUserMapper;
import com.xcgn.marry.business.model.business.BusinessUser;
import com.xcgn.marry.business.service.buiness.QQService;
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
@Service("qqService")
public class QQServiceImpl implements QQService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private BusinessUserMapper businessUserMapper;
    /**
     * description: qq登录
     * version: 1.0 
     * date: 2019/11/18 11:39 
     * author: ajaxgo
     * 
     * @param openId
 * @param nickname
 * @param headImgUrl
     * @return com.xcgn.marry.business.utils.HttpResponse
     */ 
    @Override
    public ResponseEntity qqLogin(Integer userId, String openId, String nickname, String headImgUrl) {
        BusinessUser addUser=new BusinessUser();
        addUser.setNickName(nickname);
        addUser.setAvatar(headImgUrl);
        addUser.setQqOpenId(openId);
        addUser.setId(userId);
        addUser.setCreateTime(new Date());
        try {
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
