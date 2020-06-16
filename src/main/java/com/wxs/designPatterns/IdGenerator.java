package com.wxs.designPatterns;

import java.util.concurrent.atomic.AtomicLong;

/**
 * 类描述  ：
 * 创建人  : 吴绪森
 * 创建时间：2020-06-16
 * 修改人  ：
 * 修改时间：
 * 修改备注：
 * 版    本： V1.0
 */

public class IdGenerator {

    private AtomicLong id = new AtomicLong(0);

    private static final IdGenerator instance = new IdGenerator();

    private IdGenerator(){}

    public static IdGenerator getInstance(){
        return instance;
    }

    public long getId(){
        return id.incrementAndGet();
    }


    public static void main(String[] args) {


        long id = IdGenerator.getInstance().getId();
    }
}

class IdGenerator1{

    private AtomicLong id = new AtomicLong(0);

    private IdGenerator1(){}


    private static class SingletonHolder{
        private static final IdGenerator1 instance = new IdGenerator1();
    }

    public static IdGenerator1 getInstance(){
        return SingletonHolder.instance;
    }


    public long getId(){
        return id.incrementAndGet();
    }


}
