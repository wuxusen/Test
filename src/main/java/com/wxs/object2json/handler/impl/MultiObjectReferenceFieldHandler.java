package com.wxs.object2json.handler.impl;

import com.wxs.object2json.handler.CommonHandler;
import com.wxs.object2json.handler.Fieldhandler;
import com.wxs.object2json.vo.ExcelDataVO;
import com.wxs.object2json.vo.FieldDescribe;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 类描述  ：
 * 创建人  : 吴绪森
 * 创建时间：2020-09-20
 * 修改人  ：
 * 修改时间：
 * 修改备注：
 * 版    本： V1.0
 */

public class MultiObjectReferenceFieldHandler extends CommonHandler implements Fieldhandler  {



    @Override
    public FieldDescribe createField(ExcelDataVO excelDataVO) {



        MultiObjectReferenceFieldDescribe field = new MultiObjectReferenceFieldDescribe();
        field.setApiName(excelDataVO.getLocalAlias() == null ? excelDataVO.getEsApiName() : excelDataVO.getLocalAlias());
        field.setType(excelDataVO.getLocalType());
        field.setLabel(excelDataVO.getLabel());
        field.setDescription("");
        field.setDefineType("system");
        field.setIsIndex(true);
        field.setIsActive(false);

        field.setTargetApiName("");
        field.setTargetRelatedListLabel("");
        field.setTargetRelatedListName("");

        field.setConfig(buildConfig(excelDataVO.getEsType(),excelDataVO.getEsApiName(),excelDataVO.getAttribute()));
        return field;
    }



    @Data
    @NoArgsConstructor
    class MultiObjectReferenceFieldDescribe extends FieldDescribe{

        private Boolean isActive;
        private String targetApiName;
        private String targetRelatedListLabel;
        private String targetRelatedListName;
    }


}
