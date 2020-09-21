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
public class FieldDescribe {

        private String apiName;
        private String type;
        private String label;
        private String description;
        private String defineType;


        private Boolean required;
        private Boolean isIndex;
        private Config config;




}
