package com.xcgn.marry.business.service.buiness;

/**
 * 可自行扩展
 * @author Zheng Jie
 * @date 2018-12-10
 */
public interface RedisService {
    /**
     * 查询验证码的值
     * @param key 键
     * @return /
     */
    String getCodeVal(String key);

    /**
     * 保存验证码
     * @param key 键
     * @param expiration 缓存时间
     * @param val 值
     */
    void saveCode(String key,Long expiration, Object val);

}
