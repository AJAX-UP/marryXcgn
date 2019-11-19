
package com.xcgn.marry.business.utils.wxzf.entity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.beans.Transient;
import java.util.HashMap;
import java.util.Map;


@Component
public class TransfersDto
{
    // 与商户号关联应用(如微信公众号/小程序)的APPID
    private String mch_appid;

    // 微信支付分配的商户号
    private String mchid;
    
    // 商户名称, 如'XXX服务号'
    private String mch_name;

    // 商户订单号，需保持唯一性(只能是字母或者数字，不能包含有其他字符)
    private String partner_trade_no;

    // 商户appid下，某用户的openid
    private String openid;

    // NO_CHECK：不校验真实姓名 FORCE_CHECK：强校验真实姓名
    private String check_name;

    // 企业付款金额，单位为元
    private int amount;
    
    // 随机字符串，不长于32位
    private String nonce_str;

    // 企业付款备注
    private String desc;

    private String appkey;

    // 发起者IP地址+该IP可传用户端或者服务端的IP。
    private String spbill_create_ip;

    @Value("${wxPay.Mch_appid}")
    public void setMch_appid(String mch_appid) {
        this.mch_appid = mch_appid;
    }

    @Value("${wxPay.Mchid}")
    public void setMchid(String mchid) {
        this.mchid = mchid;
    }

    @Value("${wxPay.Mch_name}")
    public void setMch_name(String mch_name) {
        this.mch_name = mch_name;
    }


    public void setPartner_trade_no(String partner_trade_no) {
        this.partner_trade_no = partner_trade_no;
    }


    public void setOpenid(String openid) {
        this.openid = openid;
    }

    @Value("${wxPay.check_name}")
    public void setCheck_name(String check_name) {
        this.check_name = check_name;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setNonce_str(String nonce_str) {
        this.nonce_str = nonce_str;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Value("${wxPay.appkey}")
    public void setAppkey(String appkey) {
        this.appkey = appkey;
    }

    @Value("${wxPay.create_ip}")
    public void setSpbill_create_ip(String spbill_create_ip) {
        this.spbill_create_ip = spbill_create_ip;
    }

    public String getMch_appid() {
        return mch_appid;
    }

    public String getMchid() {
        return mchid;
    }

    public String getMch_name() {
        return mch_name;
    }

    public String getPartner_trade_no() {
        return partner_trade_no;
    }

    public String getOpenid() {
        return openid;
    }

    public String getCheck_name() {
        return check_name;
    }

    public int getAmount() {
        return amount;
    }

    public String getNonce_str() {
        return nonce_str;
    }

    public String getDesc() {
        return desc;
    }

    public String getAppkey() {
        return appkey;
    }

    public String getSpbill_create_ip() {
        return spbill_create_ip;
    }

    //@Value("${wxPay.appkey}")
}
