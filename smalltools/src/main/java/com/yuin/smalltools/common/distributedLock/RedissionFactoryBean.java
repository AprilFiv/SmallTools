package com.yuin.smalltools.common.distributedLock;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.apache.log4j.Logger;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Value;

/**
 * 创建分布式锁模板实例的工厂Bean
 *
 * @author lk
 */
public class RedissionFactoryBean implements FactoryBean<DistributedLockTemplate> {
    private Logger                  logger = Logger.getLogger(RedissionFactoryBean.class);

    private LockInstanceMode        mode;

    private DistributedLockTemplate distributedLockTemplate;

    private RedissonClient redisson;
    @Value("${spring.redis.host}")
    private String host;
    @Value("${spring.redis.port}")
    private int port;
    @PostConstruct
    public void init() {
        Config config=new Config();
        config.useSingleServer().setAddress(host+":"+port);
        redisson=Redisson.create(config);
        System.out.println("成功连接Redis Server"+"\t"+"连接"+host+":"+port+"服务器");
    }

    @PreDestroy
    public void destroy() {
        logger.debug("销毁分布式锁模板");
        redisson.shutdown();
    }

    @Override
    public DistributedLockTemplate getObject() throws Exception {
        switch (mode) {
            case SINGLE:
                distributedLockTemplate = new SingleDistributedLockTemplate(redisson);
                break;
        }
        return distributedLockTemplate;
    }


    @Override
    public Class<?> getObjectType() {
        return DistributedLockTemplate.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }

    public void setMode(String mode) {
        if (mode==null||mode.length()<=0||mode.equals("")) {
            throw new IllegalArgumentException("未找到dlm.redisson.mode配置项");
        }
        this.mode = LockInstanceMode.parse(mode);
        if (this.mode == null) {
            throw new IllegalArgumentException("不支持的分布式锁模式");
        }
    }

    private enum LockInstanceMode {
        SINGLE;
        public static LockInstanceMode parse(String name) {
            for (LockInstanceMode modeIns : LockInstanceMode.values()) {
                if (modeIns.name().equals(name.toUpperCase())) {
                    return modeIns;
                }
            }
            return null;
        }
    }
}