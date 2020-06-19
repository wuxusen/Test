package com.wxs.designPatterns;

import com.google.common.eventbus.Subscribe;

public class RegNotificationObserver {
  private NotificationService notificationService = new NotificationService();

  @Subscribe
  public void handleRegSuccess(EventBusDemo.MyEvent userId) {
    notificationService.sendInboxMessage(new EventBusDemo.MyEvent(""), "...");
  }
}