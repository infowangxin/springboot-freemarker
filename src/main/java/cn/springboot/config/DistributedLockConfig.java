package cn.springboot.config;

import cn.springboot.framework.locks.zookeeper.ZookeeperLockFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * 分布式锁配置
 *
 * @author 胡桃夹子
 * @date 2022-02-18 09:02
 */
@Component
public class DistributedLockConfig {

    @Value("${locks.zookeeper.namespace}")
    private String namespace;

    @Value("${locks.zookeeper.connect-server}")
    private String connectServer;

    @Value("${locks.zookeeper.connection-timeout}")
    private int connectionTimeout;

    @Value("${locks.zookeeper.session-timeout}")
    private int sessionTimeout;

    @Bean(initMethod = "init", destroyMethod = "destroy")
    public ZookeeperLockFactory zookeeperLockFactory() {
        //LOG.debug("# ZookeeperLockFactory namespace={},connectServer={},connectionTimeout={},sessionTimeout={}", namespace, connectServer, connectionTimeout, sessionTimeout);
        return new ZookeeperLockFactory(namespace, connectServer, connectionTimeout, sessionTimeout);
    }

}
