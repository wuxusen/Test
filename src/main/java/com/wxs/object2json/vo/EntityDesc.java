package com.wxs.object2json.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 类描述  ：
 * 创建人  : 吴绪森
 * 创建时间：2020-09-20
 * 修改人  ：
 * 修改时间：
 * 修改备注：
 * 版    本： V1.0
 */

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class EntityDesc {

    private String appId;
    private String apiName;
    private String displayName;
    private String defineType;
    private String description;
    private String storeTableName;
    private Boolean hiddenForObjectList;
    private List<FieldDescribe> fieldDescribes;

}
