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

public class CaCheTest {


    public static void main(String[] args) {


        // 普通用户缓存操作
        CacheOp cacheOp = new CacheOpImpl();
        cacheOp.put("key","value");
        cacheOp.get("key");
        cacheOp.delete("key");

        // 远程系统
        // 远程配置文件
        Config config = new Config();
        CacheReBuildImpl cacheReBuild = new CacheReBuildImpl();

        CutOverCache cutOverCache = new CutOverCache(cacheReBuild, config);
        cutOverCache.cutOver();


    }
}
