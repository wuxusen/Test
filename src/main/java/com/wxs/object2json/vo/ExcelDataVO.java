package com.wxs.object2json.vo;

import lombok.Data;

/**
 * 类描述  ：
 * 创建人  : 吴绪森
 * 创建时间：2020-09-20
 * 修改人  ：
 * 修改时间：
 * 修改备注：
 * 版    本： V1.0
 */

@Data
public class ExcelDataVO {




    private String esApiName;
    private String esType;
    private String label;
    private String mark;


    /**
     * 系统使用类型
     */
    private String localType;
    /**
     * 系统使用别名
     */
    private String localAlias;


    private String attribute;

    private String options;



}
