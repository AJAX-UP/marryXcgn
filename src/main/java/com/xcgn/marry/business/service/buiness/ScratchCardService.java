package com.xcgn.marry.business.service.buiness;

import com.xcgn.marry.business.model.business.BusinessCardList;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * create by ajaxgo on 2019/11/19
 **/
public interface ScratchCardService {

    ResponseEntity selectCardList(Integer userId);

    ResponseEntity selectInfo(Integer userId,Integer cardId);

    ResponseEntity addCashBean(Integer userId,Integer cardId,Integer level,boolean isDouble,String key);
}
