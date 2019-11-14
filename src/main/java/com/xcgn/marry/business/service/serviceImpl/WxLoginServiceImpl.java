package com.xcgn.marry.business.service.serviceImpl;

import com.alibaba.fastjson.JSONObject;
import com.xcgn.marry.business.service.WxLoginService;
import com.xcgn.marry.business.utils.AuthUtil;
import org.springframework.stereotype.Service;

/**
 * create by ajaxgo on 2019/11/12
 **/
@Service("wxService")
public class WxLoginServiceImpl implements WxLoginService {

    /**
     * @throws
     * @title weChatLogin
     * @description 微信授权登录
     * @author Kuangzc
     * @updateTime 2019-9-12 16:00:51
     */
    @Override
    public JSONObject weChatLogin(String code) {
        JSONObject resultObj = new JSONObject();
        try {
            //通过第一步获得的code获取微信授权信息
            String url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=" + AuthUtil.APPID + "&secret="
                    + AuthUtil.APPSECRET + "&code=" + code + "&grant_type=authorization_code";
            JSONObject jsonObject = AuthUtil.doGetJson(url);
            String openid = jsonObject.getString("openid");
            String token = jsonObject.getString("access_token");
            String infoUrl = "https://api.weixin.qq.com/sns/userinfo?access_token=" + token + "&openid=" + openid
                    + "&lang=zh_CN";
            JSONObject userInfo = AuthUtil.doGetJson(infoUrl);
            //成功获取授权,以下部分为业务逻辑处理了，根据个人业务需求写就可以了
            if (userInfo != null && openid != null) {
                String nickname = userInfo.getString("nickname");
                String headimgurl = userInfo.getString("headimgurl");
                headimgurl = headimgurl.replace("\\", "");
                /**
                处理业务逻辑
                 */

                //根据openid查询时候有用户信息
//                ResponseMemberDTO memberDTO = appCoreMemberMapper.getMemberInfoByOpenid(openid);
//                if (Objects.isNull(memberDTO)) {
//
//                    //没有绑定用户请前往绑定
//                    HashMap map = new HashMap();
//                    map.put("state", "1");
//                    map.put("openid", openid);
//                    map.put("token", "");
//                    map.put("nickname", nickname);
//                    map.put("photo", headimgurl);
//                    return (JSONObject) resultObj.put("登录成功", map);
//                } else {
//
//                    //已经绑定用户信息直接登录
//                    User userInfos = UserInfo.build(memberDTO.getId().longValue(), memberDTO.getMobile(), new Date(), 1);
//                    String Token = tokenManager.setToken(userInfos);
//                    // 缓存权限
//                    Map<String, String> httpUrl = new HashMap<>();
//                    httpUrl.put("kylin", "shuoye.com:8484");
//                    authHandler.setRoleUrl(memberDTO.getId().toString(), httpUrl);
//                    HashMap map = new HashMap();
//                    map.put("state", "2");
//                    map.put("openid", openid);
//                    map.put("token", Token);
//                    return (JSONObject) resultObj.put("登录成功", map);
//                }
                return (JSONObject) resultObj.put("登录失败","");
            } else {
                return (JSONObject) resultObj.put("登录失败","");
            }
        } catch (Exception e) {
            return (JSONObject) resultObj.put("登录失败","");
        }
    }
}
