package com.wxs;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * 类描述  ：
 * 创建人  : 吴绪森
 * 创建时间：2019-10-23
 * 修改人  ：
 * 修改时间：
 * 修改备注：
 * 版    本： V1.0
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Person {

    private int age;
    private String name;

    private Long show;

    private BigDecimal amount;


}
