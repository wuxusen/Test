package com.wxs.log;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;

/**
 * 类描述  ：
 * 创建人  : 吴绪森
 * 创建时间：2019-08-26
 * 修改人  ：
 * 修改时间：
 * 修改备注：
 * 版    本： V1.0
 */

@Slf4j
public class LogTest {


    public static void main(String[] args) {

        String s = JSON.toJSONString(null);

        System.out.println(s);

    }
}
