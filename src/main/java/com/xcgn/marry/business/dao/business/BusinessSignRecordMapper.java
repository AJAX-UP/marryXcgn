package com.xcgn.marry.business.dao.business;


import com.xcgn.marry.business.model.business.BusinessSignRecord;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


@Mapper
public interface BusinessSignRecordMapper {

    int deleteByPrimaryKey(Integer id);


    int insertSelective(BusinessSignRecord record);


    BusinessSignRecord selectByPrimaryKey(Integer id);


    int updateByPrimaryKeySelective(BusinessSignRecord record);

}