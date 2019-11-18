package com.xcgn.marry.business.service.buiness.serviceImpl;

import com.alibaba.fastjson.JSONObject;
import com.xcgn.marry.business.dao.business.BusinessUserMapper;
import com.xcgn.marry.business.model.business.BusinessUser;
import com.xcgn.marry.business.service.buiness.WxLoginService;
import com.xcgn.marry.business.utils.AuthUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * create by ajaxgo on 2019/11/12
 **/
@Service("wxService")
public class WxLoginServiceImpl implements WxLoginService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private BusinessUserMapper businessUserMapper;
    /**
     * @throws
     * @title weChatLogin
     * @description 微信授权登录
     * @author Kuangzc
     * @updateTime 2019-9-12 16:00:51
     */
    @Override
    public ResponseEntity weChatLogin(Integer userId, String code) {
        try {
            //通过第一步获得的code获取微信授权信息
            JSONObject jsonObject = AuthUtil.doGetOpenId(code);
            String openid = jsonObject.getString("openid");
            String token = jsonObject.getString("access_token");
            JSONObject userInfo = AuthUtil.doGetUserInfo(token,openid);
            //成功获取授权,以下部分为业务逻辑处理了，根据个人业务需求写就可以了
            if (userInfo != null && openid != null) {
                BusinessUser bUser=businessUserMapper.selectByOpenId(openid);
                if(bUser!=null){
                  //已有账号
                    return  new ResponseEntity<>(bUser, HttpStatus.OK);
                }else{
                  //首次登录
                  BusinessUser addUser=new BusinessUser();
                  addUser.setNickName(userInfo.getString("nickname"));
                  addUser.setAvatar(userInfo.getString("headimgurl"));
                  addUser.setWxOpenId(openid);
                  addUser.setCreateTime(new Date());
                  addUser.setId(userId);
                  int i =businessUserMapper.updateByPrimaryKeySelective(addUser);
                  if(i!=0){
                      return  new ResponseEntity<>(addUser, HttpStatus.OK);
                  }else{
                      return  new ResponseEntity<>("未知错误", HttpStatus.INTERNAL_SERVER_ERROR);
                  }
                }
            } else {
                return  new ResponseEntity<>("未知错误", HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
            return  new ResponseEntity<>("未知错误", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * description: 绑定微信
     * version: 1.0 
     * date: 2019/11/18 11:10 
     * author: ajaxgo
     * 
     * @param code
    * @param userId
     * @return com.xcgn.marry.business.utils.HttpResponse
     */ 
    @Override
    public ResponseEntity bindWeChat(String code, Integer userId) {
        try {
           JSONObject jsonObject = AuthUtil.doGetOpenId(code);
           String openid = jsonObject.getString("openid");
           if(openid!=null){
               BusinessUser updateUser=new BusinessUser();
               updateUser.setId(userId);
               updateUser.setUpdateTime(new Date());
               updateUser.setWxOpenId(openid);
               int i=businessUserMapper.updateByPrimaryKeySelective(updateUser);
               if(i!=0){
                   return  new ResponseEntity<>(updateUser, HttpStatus.OK);
               }else{
                   return  new ResponseEntity<>(updateUser, HttpStatus.INTERNAL_SERVER_ERROR);
               }
           }
       }catch (Exception e){
            logger.error(e.getMessage());
            return  new ResponseEntity<>("未知错误", HttpStatus.INTERNAL_SERVER_ERROR);
       }
        return  new ResponseEntity<>("未知错误", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
