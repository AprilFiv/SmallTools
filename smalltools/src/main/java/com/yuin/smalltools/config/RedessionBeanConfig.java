package com.yuin.smalltools.config;
import com.yuin.smalltools.common.distributedLock.RedissionFactoryBean;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * Created by LiaoKe on 2017/5/22.
 */
@Configuration
public class RedessionBeanConfig {

    @Bean
    public RedissionFactoryBean distributeLockTemplate(){
        RedissionFactoryBean d  = new RedissionFactoryBean();
        d.setMode("SINGLE");
        return d;
    }

}