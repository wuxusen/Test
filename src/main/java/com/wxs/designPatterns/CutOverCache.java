package com.wxs.designPatterns;

/**
 * 类描述  ：
 * 创建人  : 吴绪森
 * 创建时间：2020-06-15
 * 修改人  ：
 * 修改时间：
 * 修改备注：
 * 版    本： V1.0
 */

public class CutOverCache {


    private  CacheReBuild cacheReBuild;

    private Config config;

    public CutOverCache(CacheReBuild cacheReBuild,Config config){

        this.cacheReBuild = cacheReBuild;
        this.config = config;
    }


    public void cutOver(){

        this.cacheReBuild.reBuild(config);

    }

}
