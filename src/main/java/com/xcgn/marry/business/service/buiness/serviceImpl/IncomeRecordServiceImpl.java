package com.xcgn.marry.business.service.buiness.serviceImpl;

import com.xcgn.marry.business.dao.business.BusinessIncomeRecordMapper;
import com.xcgn.marry.business.dao.business.BusinessUserMapper;
import com.xcgn.marry.business.model.business.BusinessIncomeRecord;
import com.xcgn.marry.business.model.business.BusinessUser;
import com.xcgn.marry.business.service.buiness.IncomeRecordService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * create by ajaxgo on 2019/11/19
 **/
@Service("incomeRecordService")
public class IncomeRecordServiceImpl implements IncomeRecordService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private BusinessIncomeRecordMapper businessIncomeRecordMapper;

    @Autowired
    private BusinessUserMapper businessUserMapper;
    /**
     * description: 兑换现金
     * version: 1.0 
     * date: 2019/11/19 15:32 
     * author: ajaxgo
     * 
     * @param userId
 * @param cashBean
     * @return org.springframework.http.ResponseEntity
     */ 
    @Override
    @Transactional
    public ResponseEntity exchangeCash(Integer userId, Integer cashBean) {
        BusinessIncomeRecord bir=new BusinessIncomeRecord();
        BusinessUser bu =businessUserMapper.selectByPrimaryKey(userId);
        if(bu.getCashBeans()<cashBean){
            return new ResponseEntity("现金豆不足", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        bir.setCashBean(cashBean);
        bir.setCash(cashBean/10000.00);
        bir.setUserId(userId);
        bir.setCreateTime(new Date());
        businessIncomeRecordMapper.insertSelective(bir);
        if(bu!=null){
            BusinessUser ubu=new BusinessUser();
            ubu.setId(userId);
            ubu.setCashBeans(bu.getCashBeans()-cashBean);
            ubu.setCash(bu.getCash()+cashBean/10000.00);
            businessUserMapper.updateByPrimaryKeySelective(ubu);
            return new ResponseEntity("兑换成功", HttpStatus.OK);
        }else{
            return new ResponseEntity("未知错误", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * description: 兑换明细
     * version: 1.0
     * date: 2019/11/19 15:49
     * author: ajaxgo
     *
     * @param userId
     * @return org.springframework.http.ResponseEntity
     */
    @Override
    public ResponseEntity exchangeDetail(Integer userId) {
        try {
            List<BusinessIncomeRecord> list=businessIncomeRecordMapper.selectByUserId(userId);
            return new ResponseEntity(list, HttpStatus.OK);
        }catch (Exception e){
            logger.error(e.getMessage());
           return new ResponseEntity("未知错误", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
