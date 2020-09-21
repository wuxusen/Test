package com.wxs.object2json.handler;

import com.wxs.object2json.vo.ExcelDataVO;
import com.wxs.object2json.vo.FieldDescribe;

/**
 * 类描述  ：
 * 创建人  : 吴绪森
 * 创建时间：2020-09-20
 * 修改人  ：
 * 修改时间：
 * 修改备注：
 * 版    本： V1.0
 */

public interface Fieldhandler {

    FieldDescribe createField(ExcelDataVO excelDataVO);

}
