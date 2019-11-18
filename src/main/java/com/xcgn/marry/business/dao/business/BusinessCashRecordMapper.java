package com.xcgn.marry.business.dao.business;


import com.xcgn.marry.business.model.business.BusinessCashRecord;


public interface BusinessCashRecordMapper {

    int deleteByPrimaryKey(Integer id);


    int insertSelective(BusinessCashRecord record);


    BusinessCashRecord selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BusinessCashRecord record);

}