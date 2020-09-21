package com.wxs.object2json.handler;

import com.alibaba.fastjson.JSON;
import com.wxs.object2json.vo.Config;
import com.wxs.object2json.vo.Remote;

import java.util.Map;

/**
 * 类描述  ：
 * 创建人  : 吴绪森
 * 创建时间：2020-09-21
 * 修改人  ：
 * 修改时间：
 * 修改备注：
 * 版    本： V1.0
 */

public class CommonHandler {


    protected Config buildConfig(String esType, String esApiName) {

        Remote remote = new Remote();
        remote.setType(esType);
        remote.setApiName(esApiName);


        Config config = new Config();
        config.setRemote(remote);

        return config;

    }


    protected Config buildConfig(String esType, String esApiName, String attribute) {

        Remote remote = new Remote();

        remote.setApiName(esApiName);

        if (!"object".equals(esType)) {
            remote.setType(esType);
        }
        if (attribute != null) {
            Map map = JSON.parseObject(attribute, Map.class);
            remote.setProperties(map);
        }
        Config config = new Config();
        config.setRemote(remote);

        return config;

    }

}
