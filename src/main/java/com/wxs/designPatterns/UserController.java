package com.wxs.designPatterns;

import com.google.common.eventbus.EventBus;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Arrays;
import java.util.List;

public class UserController {

  private UserService userService= new UserService();

  private EventBus eventBus;
  private static final int DEFAULT_EVENTBUS_THREAD_POOL_SIZE = 20;

  public UserController() {
    eventBus = new EventBus(); // 同步阻塞模式
   // eventBus = new AsyncEventBus(Executors.newFixedThreadPool(DEFAULT_EVENTBUS_THREAD_POOL_SIZE)); // 异步非阻塞模式
  }

  public void setRegObservers(List<Object> observers) {
    for (Object observer : observers) {
      eventBus.register(observer);
    }
  }

  public Long register(String telephone, String password) {
    //省略输入参数的校验代码
    //省略userService.register()异常的try-catch代码
    long userId = userService.register(telephone, password);

    eventBus.post(new MyEvent("aaaaaaaaaaa"));

    return userId;
  }


  public static void main(String[] args) {

    UserController userController = new UserController();

    userController.setRegObservers(Arrays.asList(new RegNotificationObserver()));
    Long register = userController.register("11", "11");

    System.out.println("reg");


  }

  @Data
  @AllArgsConstructor
  public static class MyEvent {
    String id;

  }
}




