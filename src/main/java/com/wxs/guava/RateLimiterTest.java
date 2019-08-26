package com.wxs.guava;

import com.google.common.util.concurrent.RateLimiter;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 类描述  ：
 * 创建人  : 吴绪森
 * 创建时间：2019-08-09
 * 修改人  ：
 * 修改时间：
 * 修改备注：
 * 版    本： V1.0
 */

public class RateLimiterTest {


    public static void main(String[] args) {
        // 限流器流速：2 个请求 / 秒
        RateLimiter limiter = RateLimiter.create(4.0);
// 执行任务的线程池
        ExecutorService es = Executors.newFixedThreadPool(1);
// 记录上一次执行时间
        Map<String,Long> timeMap = new HashMap<>();
        timeMap.put("prev",System.nanoTime());

// 测试执行 20 次
        for (int i = 0; i < 20; i++) {
            // 限流器限流
            limiter.acquire();
            // 提交任务异步执行
            es.execute(() -> {
                long cur = System.nanoTime();
                // 打印时间间隔：毫秒
                System.out.println((cur - timeMap.get("prev")) / 1000_000);
                timeMap.put("prev",cur);

            });
        }


    }
}
