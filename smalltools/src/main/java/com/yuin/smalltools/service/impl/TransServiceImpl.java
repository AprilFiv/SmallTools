package com.yuin.smalltools.service.impl;

import com.alibaba.fastjson.JSON;
import com.yuin.smalltools.common.Constant;
import com.yuin.smalltools.entity.trans.TransInfoVo;
import com.yuin.smalltools.service.TransService;
import com.yuin.smalltools.thrift.ThriftService;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class TransServiceImpl implements TransService {
    @Autowired
    RedisTemplate<String, String> redisTemplate;

    @Autowired
    ThriftService thriftService;
    @Override
    public String[] sendUrl(String transUrl) {
        Object obj = redisTemplate.opsForValue().get(transUrl);
        if (obj!=null){
            return ((String)obj).substring(2,((String) obj).length()-2).split(",");
        } else {
            try {
                thriftService.transUrl(transUrl);
                for (;;){
                    System.out.println(1);
                    obj = redisTemplate.opsForValue().get(transUrl);
                    if (obj!=null){
                        return ((String)obj).substring(2,((String) obj).length()-2).split(",");
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
    }
}
