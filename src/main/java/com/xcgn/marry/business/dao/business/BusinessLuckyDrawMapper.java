package com.xcgn.marry.business.dao.business;


import com.xcgn.marry.business.model.business.BusinessLuckyDraw;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


@Mapper
public interface BusinessLuckyDrawMapper {

    int deleteByPrimaryKey(Integer id);


    int insertSelective(BusinessLuckyDraw record);


    BusinessLuckyDraw selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BusinessLuckyDraw record);

}