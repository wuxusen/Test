package com.wxs.zk;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.locks.InterProcessLock;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.data.Stat;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 类描述  ：https://www.throwable.club/2018/12/16/zookeeper-curator-usage/
 * 创建人  : 吴绪森
 * 创建时间：2020-06-10
 * 修改人  ：
 * 修改时间：
 * 修改备注：
 * 版    本： V1.0
 */

public class CuratorFrameTest {


    @Autowired
    private CuratorFramework curatorFramework;


    public  void main(String[] args) throws Exception {


        curatorFramework.create().forPath("path");

        curatorFramework.create().forPath("","a".getBytes());

        curatorFramework.create().withMode(CreateMode.EPHEMERAL).forPath("");
        curatorFramework.create().withMode(CreateMode.EPHEMERAL).forPath("","a".getBytes());



        curatorFramework.create().creatingParentContainersIfNeeded().withMode(CreateMode.EPHEMERAL).forPath("");

        curatorFramework.delete().forPath("");

        curatorFramework.delete().deletingChildrenIfNeeded().forPath("");

        curatorFramework.delete().withVersion(1000).forPath("");

        curatorFramework.delete().guaranteed().forPath("");


        curatorFramework.delete().guaranteed().deletingChildrenIfNeeded().withVersion(100).forPath("");



        curatorFramework.getData().forPath("");

        Stat stat = new Stat();
        curatorFramework.getData().storingStatIn(stat).forPath("");


        curatorFramework.setData().withVersion(11).forPath(""," ".getBytes());


        InterProcessLock lock = new InterProcessMutex(curatorFramework,"aaa");
        lock.acquire();
        lock.release();



    }


}
