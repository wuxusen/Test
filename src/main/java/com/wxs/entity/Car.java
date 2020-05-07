package com.wxs.entity;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.wxs.Person;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 类描述  ：
 * 创建人  : 吴绪森
 * 创建时间：2019-11-12
 * 修改人  ：
 * 修改时间：
 * 修改备注：
 * 版    本： V1.0
 */

@Data
public class Car {

    public static void main(String[] arg) {

        Person person = new Person();
        person.setAmount(new BigDecimal("167"));



        Person person2 = new Person();
        person2.setAmount(new BigDecimal("300"));


        List<Person> list = Lists.newArrayList(person,person2);




        BigDecimal businessSpending = list.stream().map(Person::getAmount).reduce(BigDecimal.ZERO, BigDecimal::add);


        System.out.println(businessSpending);
    }

    public static String parseNumber(String pattern, BigDecimal bd) {
        DecimalFormat df = new DecimalFormat(pattern);

        String format = df.format(bd);
        return df.format(bd);
    }

    public static Map<String,String> mapStringToMap(String str){
        str=str.substring(1, str.length()-1);
        String[] strs=str.split(",");
        Map<String,String> map = new HashMap<String, String>();
        for (String string : strs) {
            String key=string.split("=")[0];
            String value=string.split("=")[1];
            map.put(key, value);
        }
        return map;
    }

    public static ArrayList<Car> getInfo(){
        Bus bus1 = Bus.builder().name("宝马1").price("1001").build();
        Bus bus2 = Bus.builder().name("宝马2").price("1002").build();
        Bus bus3 = Bus.builder().name("宝马3").price("1003").build();


        Truckus t1 = Truckus.builder().show("描述1").b("b1").build();
        Truckus t2 = Truckus.builder().show("描述2").b("b2").build();
        Truckus t3 = Truckus.builder().show("描述3").b("b3").build();


        ArrayList<Car> cars = Lists.newArrayList(bus1, bus2, bus3, t1, t2, t3);

        HashMap<String, ArrayList<Car>> map = Maps.newHashMap();


        map.put("aaa",cars);


        Bus car = (Bus)cars.get(0);

        car.setName("dadadadada");





        return cars;
    }



}


@Data
@Builder
class Bus extends Car{

    private String name;
    private String price;

}

@Builder
@Data
class Truckus extends Car{

    private String show;
    private String b;

}

