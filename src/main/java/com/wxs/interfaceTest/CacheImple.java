package com.wxs.interfaceTest;

/**
 * 类描述  ：
 * 创建人  : 吴绪森
 * 创建时间：2020/6/14
 * 修改人  ：
 * 修改时间：
 * 修改备注：
 * 版    本： V1.0
 */

public interface CacheImple {

    Object get(Object key);

    Object put(Object key,Object value);

    Object delete(Object key);



}
