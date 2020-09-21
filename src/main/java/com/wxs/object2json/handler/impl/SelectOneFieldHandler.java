package com.wxs.object2json.handler.impl;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.wxs.object2json.handler.CommonHandler;
import com.wxs.object2json.handler.Fieldhandler;
import com.wxs.object2json.vo.ExcelDataVO;
import com.wxs.object2json.vo.FieldDescribe;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.util.StringUtils;

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

public class SelectOneFieldHandler extends CommonHandler implements Fieldhandler  {



    @Override
    public FieldDescribe createField(ExcelDataVO excelDataVO) {



        SelectOneFieldDescribe field = new SelectOneFieldDescribe();
        field.setApiName(excelDataVO.getLocalAlias() == null ? excelDataVO.getEsApiName() : excelDataVO.getLocalAlias());
        field.setType(excelDataVO.getLocalType());
        field.setLabel(excelDataVO.getLabel());
        field.setDescription("");
        field.setDefineType("system");
        field.setIsIndex(true);

        field.setSelectOptions(buildOptions(excelDataVO.getOptions()));

        field.setConfig(buildConfig(excelDataVO.getEsType(),excelDataVO.getEsApiName(),excelDataVO.getAttribute()));
        return field;
    }

    private List<SelectOption> buildOptions(String options) {

        if(StringUtils.isEmpty(options)) return null;

        List<SelectOption> list = Lists.newArrayList();


        Map map = JSON.parseObject(options, Map.class);

        map.forEach((k,v)->{
            SelectOption rt = new SelectOption();

           rt.setLabel(k.toString());
           rt.setValue(v.toString());

            list.add(rt);

        });


        return list;
    }


    @Data
    @NoArgsConstructor
    class SelectOneFieldDescribe extends FieldDescribe{


        private List<SelectOption> selectOptions;

    }


    @Data
    class SelectOption{

        private String label;
        private String value;

    }


}
