package cn.springboot.framework.locks.zookeeper;

import cn.springboot.framework.locks.DistributedLockFactory;
import cn.springboot.framework.locks.MutexLock;
import cn.springboot.framework.locks.ReadWriteLock;
import cn.springboot.framework.locks.SharedLock;
import org.apache.commons.lang3.StringUtils;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.imps.CuratorFrameworkState;
import org.apache.curator.retry.RetryNTimes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * <h3>ZooKeeper分布式锁工厂实现</h3>
 *
 * <p>基于 ZooKeeper 实现了分布式锁工厂接口{@link DistributedLockFactory DistributedLockFactory}</p>
 *
 * @author 胡桃夹子
 */
public class ZookeeperLockFactory implements DistributedLockFactory {

    private static final Logger LOG = LoggerFactory.getLogger(ZookeeperLockFactory.class);

    private static final String DEFAULT_NAMESPACE = "locks";

    private static final int DEFAULT_SESSION_TIMEOUT = 15000;

    private static final int DEFAULT_CONNECTION_TIMEOUT = 30000;

    /**
     * 锁命名空间
     */
    private String namespace;

    /**
     * zk连接地址
     */
    private String connectServer;

    /**
     * 连接超时时间
     */
    private int connectionTimeout;

    /**
     * session会话超时时间
     */
    private int sessionTimeout;

    private CuratorFramework client;

    public ZookeeperLockFactory(String namespace, String connectServer, int connectionTimeout, int sessionTimeout) {
        this.namespace = namespace;
        this.connectServer = connectServer;
        this.connectionTimeout = connectionTimeout;
        this.sessionTimeout = sessionTimeout;
    }

    public String getNamespace() {
        return namespace;
    }

    public void setNamespace(String namespace) {
        this.namespace = namespace;
    }

    public String getConnectServer() {
        return connectServer;
    }

    public void setConnectServer(String connectServer) {
        this.connectServer = connectServer;
    }

    public int getConnectionTimeout() {
        return connectionTimeout;
    }

    public void setConnectionTimeout(int connectionTimeout) {
        this.connectionTimeout = connectionTimeout;
    }

    public int getSessionTimeout() {
        return sessionTimeout;
    }

    public void setSessionTimeout(int sessionTimeout) {
        this.sessionTimeout = sessionTimeout;
    }

    @PostConstruct
    public void init() {
        LOG.debug("init ZookeeperLockFactory ...");
        if (StringUtils.isBlank(connectServer)) {
            throw new IllegalArgumentException("connectServer not exist!!!");
        }
        if (StringUtils.isBlank(namespace)) {
            namespace = DEFAULT_NAMESPACE;
        }
        if (connectionTimeout <= 0) {
            connectionTimeout = DEFAULT_CONNECTION_TIMEOUT;
        }
        if (sessionTimeout <= 0) {
            sessionTimeout = DEFAULT_SESSION_TIMEOUT;
        }
        LOG.debug("namespace: {}", namespace);
        LOG.debug("connectServer: {}", connectServer);
        LOG.debug("connectionTimeout: {}", connectionTimeout);
        LOG.debug("sessionTimeout: {}", sessionTimeout);

        client = CuratorFrameworkFactory.builder()
                .connectString(connectServer)
                .connectionTimeoutMs(connectionTimeout)
                .sessionTimeoutMs(sessionTimeout)
                .namespace(namespace)
                .retryPolicy(new RetryNTimes(Integer.MAX_VALUE, 1000))
                .build();

        client.getConnectionStateListenable().addListener(
                (client, newState) -> LOG.info("Connection State Changed: {}", newState.toString())
        );
        client.start();
        try {
            client.getZookeeperClient().blockUntilConnectedOrTimedOut();
        } catch (InterruptedException e) {
            LOG.error(e.getMessage(), e);
            throw new RuntimeException(e.getMessage(), e);
        }
        LOG.debug("init ZookeeperLockFactory ok!");
    }

    @PreDestroy
    public void destroy() {
        LOG.debug("destroy ZookeeperLockFactory ...");
        if (client != null && client.getState().equals(CuratorFrameworkState.STARTED)) {
            client.close();
            client = null;
        }
        LOG.debug("destroy ZookeeperLockFactory ok!");
    }

    @Override
    public MutexLock buildMutexLock(String name) {
        return new ZookeeperMutexLock(client, name);
    }

    @Override
    public ReadWriteLock buildReadWriteLock(String name) {
        return new ZookeeperReadWriteLock(client, name);
    }

    @Override
    public SharedLock buildSharedLock(String name, int poolSize) {
        return new ZookeeperSharedLock(client, name, poolSize);
    }

	/*
	private boolean checkLockName(String name){
		if(name==null){
			return false;
		}
		String special = "-_.,;:|<>()[]{}";
		char c;
		for(int i=0; i<name.length(); i++){
			c=name.charAt(i);
			if(!((c>='a' && c<='z') || (c>='A' && c<='Z')
					|| (c>='0' && c<='9') || special.indexOf(c)!=-1)){
				return false;
			}
		}
		return true;
	}*/
}
