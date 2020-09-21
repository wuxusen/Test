package com.wxs.object2json.handler.impl;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.wxs.object2json.handler.CommonHandler;
import com.wxs.object2json.handler.Fieldhandler;
import com.wxs.object2json.vo.ExcelDataVO;
import com.wxs.object2json.vo.FieldDescribe;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

/**
 * 类描述  ：
 * 创建人  : 吴绪森
 * 创建时间：2020-09-20
 * 修改人  ：
 * 修改时间：
 * 修改备注：
 * 版    本： V1.0
 */

public class RecordTypeFieldHandler extends CommonHandler implements Fieldhandler {


    @Override
    public FieldDescribe createField(ExcelDataVO excelDataVO) {

        RecordTypeFieldDescribe field = new RecordTypeFieldDescribe();
        field.setApiName(excelDataVO.getLocalAlias() == null ? excelDataVO.getEsApiName() : excelDataVO.getLocalAlias());
        field.setType(excelDataVO.getLocalType());
        field.setLabel(excelDataVO.getLabel());

        field.setDefineType("system");
        field.setIsActive(false);
        field.setIsIndex(true);
        field.setRecordTypeOptions(buildRecordTypeOptions(excelDataVO.getOptions()));
        field.setConfig(buildConfig(excelDataVO.getEsType(), excelDataVO.getEsApiName()));
        return field;
    }

    private List<RecordTypeOption> buildRecordTypeOptions(String options) {


        List<RecordTypeOption> list = Lists.newArrayList();


        Map map = JSON.parseObject(options, Map.class);

        map.forEach((k,v)->{
            RecordTypeOption rt = new RecordTypeOption();

            rt.setApiName(k.toString());
            rt.setLabel(v.toString());
            rt.setDescription("");
            rt.setIcon("");

            list.add(rt);

        });


        return list;
    }


    @Data
    @NoArgsConstructor
    class RecordTypeFieldDescribe extends FieldDescribe {

        private Boolean isActive;
        private List<RecordTypeOption> recordTypeOptions;

    }


    @Data
    public class RecordTypeOption {
        private String apiName;
        private String description;
        private String icon;
        private String label;
    }


}
