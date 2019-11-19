package com.xcgn.marry.business.dao.business;


import com.xcgn.marry.business.model.business.BusinessCardList;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface BusinessCardListMapper {

    int deleteByPrimaryKey(Integer id);

    int insertSelective(BusinessCardList record);


    BusinessCardList selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BusinessCardList record);

    List<BusinessCardList> selectCardList();

    List<BusinessCardList> selectCardListByCardIds(List<Integer> cardIds);

}