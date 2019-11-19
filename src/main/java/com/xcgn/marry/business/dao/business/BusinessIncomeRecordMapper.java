package com.xcgn.marry.business.dao.business;


import com.xcgn.marry.business.model.business.BusinessIncomeRecord;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface BusinessIncomeRecordMapper {

    int deleteByPrimaryKey(Integer id);



    int insertSelective(BusinessIncomeRecord record);


    BusinessIncomeRecord selectByPrimaryKey(Integer id);


    int updateByPrimaryKeySelective(BusinessIncomeRecord record);

}