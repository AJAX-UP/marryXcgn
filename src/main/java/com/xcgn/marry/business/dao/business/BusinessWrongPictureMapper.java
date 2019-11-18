package com.xcgn.marry.business.dao.business;

import com.xcgn.marry.business.model.business.BusinessWrongPicture;
import org.apache.ibatis.annotations.Param;


public interface BusinessWrongPictureMapper {

    int deleteByPrimaryKey(Integer id);


    int insertSelective(BusinessWrongPicture record);


    BusinessWrongPicture selectByPrimaryKey(Integer id);


    int updateByPrimaryKeySelective(BusinessWrongPicture record);

}