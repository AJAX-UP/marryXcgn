package com.xcgn.marry.business.dao.business;


import com.xcgn.marry.business.model.business.BusinessIncomeRecord;


public interface BusinessIncomeRecordMapper {

    int deleteByPrimaryKey(Integer id);



    int insertSelective(BusinessIncomeRecord record);


    BusinessIncomeRecord selectByPrimaryKey(Integer id);


    int updateByPrimaryKeySelective(BusinessIncomeRecord record);

}