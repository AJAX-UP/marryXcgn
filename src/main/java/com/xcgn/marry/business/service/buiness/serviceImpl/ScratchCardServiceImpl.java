package com.xcgn.marry.business.service.buiness.serviceImpl;

import com.alibaba.fastjson.JSONObject;
import com.xcgn.marry.business.dao.business.BusinessCardListMapper;
import com.xcgn.marry.business.dao.business.BusinessCardRecordMapper;
import com.xcgn.marry.business.dao.business.BusinessUserMapper;
import com.xcgn.marry.business.model.business.BusinessCardList;
import com.xcgn.marry.business.model.business.BusinessCardRecord;
import com.xcgn.marry.business.model.business.BusinessUser;
import com.xcgn.marry.business.service.buiness.RedisService;
import com.xcgn.marry.business.service.buiness.ScratchCardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * create by ajaxgo on 2019/11/19
 **/
@Service("ScratchCardService")
public class ScratchCardServiceImpl implements ScratchCardService {


    @Autowired
    private BusinessCardListMapper businessCardListMapper;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private BusinessUserMapper businessUserMapper;

    @Autowired
    private BusinessCardRecordMapper businessCardRecordMapper;

    @Autowired
    private RedisService redisService;
    /**
     * description: 查询卡片列表
     * version: 1.0 
     * date: 2019/11/19 9:55 
     * author: ajaxgo
     * 
     * @param userId
     * @return org.springframework.http.ResponseEntity
     */ 
    @Override
    public ResponseEntity selectCardList(Integer userId) {
        JSONObject result=new JSONObject();
        try {
            //获取当天刮卡次数
            List<BusinessCardRecord> list=businessCardRecordMapper.selectRecordCount(userId);
            int i=list.size();
            List<BusinessCardList> cList=new ArrayList<BusinessCardList>();
            if(i==0){
                //第一次刮卡
                cList=businessCardListMapper.selectCardList();
            }else if(i>0&&i<21){
                //刮卡不到20次
                List<Integer> cardIds=new ArrayList<Integer>();
                for(int j=0;j<i;j++){
                    cardIds.add(list.get(j).getCardId());
                }
                cList=businessCardListMapper.selectCardListByCardIds(cardIds);
            }else{
                //超过20次
                cList=businessCardListMapper.selectCardList();
            }
            result.put("data",cList);
            result.put("number",i);
            return new ResponseEntity(result, HttpStatus.OK);
        }catch (Exception e){
           logger.error(e.getMessage());
           return new ResponseEntity("未知错误", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * description: 获取中奖信息
     * version: 1.0 
     * date: 2019/11/19 11:00 
     * author: ajaxgo
     * 
     * @param userId
 * @param cardId
     * @return org.springframework.http.ResponseEntity
     */ 
    @Override
    public ResponseEntity selectInfo(Integer userId, Integer cardId) {
//        //暂时不做
//        //获取当前用户信息（计算金豆）
//        BusinessUser user=businessUserMapper.selectByPrimaryKey(userId);
//        int CashBeans= (int)(user.getCash()*10000)+user.getCashBeans();
//        //随机数1-10
//        int randNum=(int)(Math.random()*(10)+1);
        //中奖信息
        JSONObject result=new JSONObject();
        try {
            int number=(int)(Math.random()*(4)+1);
            String key=String.valueOf(System.currentTimeMillis()+userId+cardId);
            result.put("number",number);
            result.put("key",key);
            redisService.saveCode(key,10l,number);
            return new ResponseEntity(result,HttpStatus.OK);
        }catch (Exception e){
           logger.error(e.getMessage());
           return new ResponseEntity("未知错误",HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    /**
     * description: 中奖之后修改账户现金豆
     * version: 1.0 
     * date: 2019/11/19 13:57 
     * author: ajaxgo
     * 
     * @param userId
 * @param cardId
 * @param level
 * @param isDouble
 * @param key
     * @return org.springframework.http.ResponseEntity
     */ 
    @Override
    @Transactional
    public ResponseEntity addCashBean(Integer userId, Integer cardId, Integer level, boolean isDouble, String key) {
        String val=redisService.getCodeVal(key);
        if(val==null&&!val.equals(String.valueOf(level))){
            return  new ResponseEntity("数据异常",HttpStatus.INTERNAL_SERVER_ERROR);
        }
        BusinessCardRecord bcr=new BusinessCardRecord();
        bcr.setCardId(cardId);
        bcr.setUserId(userId);
        bcr.setCreateDate(new Date());
        if(isDouble){
            //翻倍
            bcr.setCashBean(level*20*3);
        }else{
            bcr.setCashBean(level*20*3);
        }
        int i=businessCardRecordMapper.insertSelective(bcr);
        if(i>0){
            BusinessUser bu=businessUserMapper.selectByPrimaryKey(userId);
            BusinessUser abu=new BusinessUser();
            abu.setId(userId);
            abu.setCashBeans(bu.getCashBeans()+bcr.getCashBean());
            businessUserMapper.updateByPrimaryKeySelective(abu);
            return  new ResponseEntity("添加成功",HttpStatus.OK);
        }else{
            return  new ResponseEntity("添加中奖纪录失败",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

//    public static void main(String[] args) {
//        List<Integer> weight =new ArrayList<>();
//        for(int t=0;t<6;t++){
//            weight.add(t+1);
//        }
//        for(int i=0;i<20;i++){
//            System.out.println(System.currentTimeMillis()+123);
//        }
//
//    }
//    public static int random(List<Integer> weight){
//        List<Integer> weightTmp = new ArrayList<Integer>(weight.size()+1);
//        weightTmp.add(0);
//        Integer sum = 0;
//        for( Integer d : weight ){
//            sum += d;
//            weightTmp.add(sum);
//        }
//        Random random = new Random();
//        int rand = random.nextInt(sum);
//        int index = 0;
//        for(int i = weightTmp.size()-1; i >0; i--){
//            if( rand >= weightTmp.get(i)){
//                index = i;
//                break;
//            }
//        }
//        return index;
//    }
}
