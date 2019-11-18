package com.xcgn.marry.business.dao.business;


import com.xcgn.marry.business.model.business.BusinessCardList;



public interface BusinessCardListMapper {

    int deleteByPrimaryKey(Integer id);

    int insertSelective(BusinessCardList record);


    BusinessCardList selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BusinessCardList record);

}