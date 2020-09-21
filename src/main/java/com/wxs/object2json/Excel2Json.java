package com.wxs.object2json;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.wxs.object2json.handler.TypeStrategy;
import com.wxs.object2json.utils.ExcelReader;
import com.wxs.object2json.vo.EntityDesc;
import com.wxs.object2json.vo.ExcelDataVO;
import com.wxs.object2json.vo.FieldDescribe;

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

public class Excel2Json {


    public static void main(String[] args) {

        String apiName = "InsightFundManagerAssociationFilingInformation";
        String displayName = "协会备案信息";
        String description = "";
        String storeTableName = "pro_jingdata_fund_manager_association_filing_information";

        // 1、读取Excel
        String excelFileName = "/Users/cygr-0101-01-0220/Downloads/objectDesc.xlsx";
        // 读取Excel文件内容
        List<ExcelDataVO> readResult = ExcelReader.readExcel(excelFileName);

        List<FieldDescribe> fields = Lists.newArrayList();

        readResult.forEach(e -> fields.add(TypeStrategy.fieldDesc(e)));

        EntityDesc entityDesc = createEntityDesc(fields, apiName, displayName, description, storeTableName);

        String str = JSON.toJSON(entityDesc).toString();

        System.out.println(str);


    }

    private static EntityDesc createEntityDesc(List<FieldDescribe> fields, String apiName, String displayName, String description, String storeTableName) {

        return EntityDesc.builder().appId("investment").apiName(apiName).displayName(displayName).defineType("system").description(description).storeTableName(storeTableName).hiddenForObjectList(true).fieldDescribes(fields).build();

    }

}
