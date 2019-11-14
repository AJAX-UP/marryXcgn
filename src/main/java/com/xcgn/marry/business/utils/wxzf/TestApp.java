package com.xcgn.marry.business.utils.wxzf;

import com.xcgn.marry.business.utils.wxzf.entity.ResultEntity;
import com.xcgn.marry.business.utils.wxzf.entity.TransfersDto;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


/**
 * QQ:2172931891 有任何关于微信开发的问题可以相互交流
 */
public class TestApp
{
    private static final Log LOG = LogFactory.getLog(TestApp.class);
    
    public static void main(String[] args)
    {

        String appkey = "BUSHULEZHUANbushulezhuan12345678";// 微信商户秘钥, 根据实际情况填写
        String certPath = "/usr/local/web_app/wxAPP/bsllz.p12";// 微信商户证书路径, 根据实际情况填写

        TransfersDto model = new TransfersDto();// 微信接口请求参数, 根据实际情况填写
        model.setMch_appid("wx371c1269ca692376"); // 申请商户号的appid或商户号绑定的appid
        model.setMchid("1551970781"); // 商户号
        model.setMch_name("星辰光年商户号"); // 商户名称
        model.setOpenid("oyICL5TcBR4xSPf0BXRSuCxmOu4o"); // 商户appid下，某用户的openid
        model.setAmount(1); // 企业付款金额，这里单位为元
        model.setDesc("测试企业付款到零钱");



        // 微信官方API文档 https://pay.weixin.qq.com/wiki/doc/api/tools/mch_pay.php?chapter=14_2
        ResultEntity iResult = WechatpayUtil.doTransfers(appkey, certPath, model);
        LOG.info(iResult);
    }
}
