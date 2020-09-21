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

public class IDFieldHandler extends CommonHandler implements Fieldhandler  {



    @Override
    public FieldDescribe createField(ExcelDataVO excelDataVO) {

        IDFieldDescribe id = new IDFieldDescribe();
        id.setApiName(excelDataVO.getLocalAlias() == null ? excelDataVO.getEsApiName() : excelDataVO.getLocalAlias());
        id.setType(excelDataVO.getLocalType());
        id.setLabel(excelDataVO.getLabel());
        id.setDescription("");
        id.setDefineType("system");
        id.setMaxLength(200);
        id.setMinLength(1);
        id.setIsIndex(true);
        id.setRequired(false);
        id.setConfig(buildConfig(excelDataVO.getEsType(),excelDataVO.getEsApiName()));

        return id;
    }




    @Data
    @NoArgsConstructor
    class IDFieldDescribe extends FieldDescribe{

        private Integer maxLength;
        private Integer minLength;


    }


}
