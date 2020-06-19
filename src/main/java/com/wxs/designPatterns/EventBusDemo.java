package com.wxs.designPatterns;

import com.google.common.eventbus.AsyncEventBus;
import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Slf4j
public class EventBusDemo {

    static ExecutorService executor =
        new ThreadPoolExecutor(2, 4, 60L, TimeUnit.SECONDS, new LinkedBlockingDeque<Runnable>(30));
    static EventBus bus = new AsyncEventBus(executor);

    public static void main(String[] args) throws InterruptedException {
        bus.register(new MyEventLisenter());
        // bus.register(new MyEventLisenter());
        log.info("post start");
        bus.post(new MyEvent(UUID.randomUUID().toString()));
        bus.post(new MyEvent(UUID.randomUUID().toString()));
        TimeUnit.SECONDS.sleep(2);
        log.info("post end");
        executor.shutdown();


    }


    @Data
    @AllArgsConstructor
    public static class MyEvent {
        String id;

    }

    @Slf4j
    public static class MyEventLisenter {

        @Subscribe
        public void onEvent(MyEvent event) {


            System.out.println("------------------------------------------------");
            log.info("onEvent>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> : {}", event.getId());
        }
    }
}