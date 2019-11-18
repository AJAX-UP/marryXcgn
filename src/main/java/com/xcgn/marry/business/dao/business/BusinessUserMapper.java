package com.xcgn.marry.business.dao.business;


import com.xcgn.marry.business.model.business.BusinessUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;



@Mapper
public interface BusinessUserMapper {

    int deleteByPrimaryKey(Integer id);



    int insertSelective(BusinessUser record);


    BusinessUser selectByPrimaryKey(Integer id);


    int updateByPrimaryKeySelective(BusinessUser record);
    /**
     * description: 查询用户 
     * version: 1.0 
     * date: 2019/11/18 10:38
     * author: ajaxgo
     * 
     * @param 
     * @return com.xcgn.marry.business.model.business.BusinessUser
     */  
    BusinessUser selectByOpenId(String wxOpenId);

}