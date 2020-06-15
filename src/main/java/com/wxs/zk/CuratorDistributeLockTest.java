package com.wxs.zk;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.apache.curator.retry.RetryNTimes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

/**
 * curator分布式锁测试
 */

public class CuratorDistributeLockTest {

//zookeeper的地址

    private static final String ZK_ADDRESS = "192.168.4.100:2181";

    private static final String ZK_LOCK_PATH = "/zkPath";

    private static Logger logger = LoggerFactory.getLogger(CuratorDistributeLockTest.class);

    private static void curatorLockTest() {

// 连接ZK

        CuratorFramework client = CuratorFrameworkFactory.newClient(

                ZK_ADDRESS,

                new RetryNTimes(10, 5000)

        );

        InterProcessMutex lock = new InterProcessMutex(client, ZK_LOCK_PATH);

        try {

            if (lock.acquire(10 * 1000, TimeUnit.SECONDS)) {

//执行业务逻辑

            }

        } catch (Exception e) {

            logger.error("业务异常", e);

        } finally {

            try {

                lock.release();

            } catch (Exception e) {

                logger.error("锁释放异常", e);

            }

        }

    }

}