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

public class NumberFieldHandler extends CommonHandler implements Fieldhandler  {



    @Override
    public FieldDescribe createField(ExcelDataVO excelDataVO) {

        NumberFieldDescribe field = new NumberFieldDescribe();
        field.setApiName(excelDataVO.getLocalAlias() == null ? excelDataVO.getEsApiName() : excelDataVO.getLocalAlias());
        field.setType(excelDataVO.getLocalType());
        field.setLabel(excelDataVO.getLabel());
        field.setDescription("");
        field.setDefineType("system");
        field.setIsIndex(true);
        field.setConfig(buildConfig(excelDataVO.getEsType(),excelDataVO.getEsApiName()));
        field.setDecimalPlaces(0);

        return field;
    }




    @Data
    @NoArgsConstructor
    class NumberFieldDescribe extends FieldDescribe{


        private Integer decimalPlaces;


    }


}
