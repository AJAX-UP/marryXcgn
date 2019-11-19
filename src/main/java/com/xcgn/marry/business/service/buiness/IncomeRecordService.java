package com.xcgn.marry.business.service.buiness;

import org.springframework.http.ResponseEntity;

/**
 * create by ajaxgo on 2019/11/19
 **/
public interface IncomeRecordService {

    ResponseEntity exchangeCash(Integer userId, Integer cashBean);

    ResponseEntity exchangeDetail(Integer userId);
}
