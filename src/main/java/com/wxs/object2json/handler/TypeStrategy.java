package com.wxs.object2json.handler;

import com.wxs.object2json.handler.impl.*;
import com.wxs.object2json.vo.ExcelDataVO;
import com.wxs.object2json.vo.FieldDescribe;

import java.util.HashMap;
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

public class TypeStrategy {


    private static final Map<String,Fieldhandler> FIELDHANDLER_MAP = new HashMap<>();


   static{

        FIELDHANDLER_MAP.put("id",new IDFieldHandler());
        FIELDHANDLER_MAP.put("text",new TextFieldHandler());
        FIELDHANDLER_MAP.put("date",new DateFieldHandler());
        FIELDHANDLER_MAP.put("object_reference",new ObjectReferenceFieldHandler());
        FIELDHANDLER_MAP.put("multi_object_reference",new MultiObjectReferenceFieldHandler());
        FIELDHANDLER_MAP.put("record_type",new RecordTypeFieldHandler());
        FIELDHANDLER_MAP.put("multi_what_object_reference",new MultiWhatObjectReferenceFieldHandler());
        FIELDHANDLER_MAP.put("currency_group",new CurrencyGroupFieldHandler());



    }


    public static FieldDescribe fieldDesc(ExcelDataVO excelDataVO){
       return FIELDHANDLER_MAP.get(excelDataVO.getLocalType()).createField(excelDataVO);

    }




}
