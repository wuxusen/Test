package com.wxs.designPatterns;

import com.google.common.eventbus.Subscribe;

public class RegPromotionObserver {

  private PromotionService promotionService = new PromotionService(); // 依赖注入

  @Subscribe
  public void handleRegSuccess(long userId) {


    promotionService.issueNewUserExperienceCash(userId);
  }
}