package com.xcgn.marry.business.dao.business;

import com.xcgn.marry.business.model.business.BusinessCardRecord;

public interface BusinessCardRecordMapper {

    int deleteByPrimaryKey(Integer id);

    int insertSelective(BusinessCardRecord record);

    BusinessCardRecord selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BusinessCardRecord record);
}