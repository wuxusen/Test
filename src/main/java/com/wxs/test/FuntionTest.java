package com.wxs.test;

import com.google.common.collect.Lists;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * 类描述  ：
 * 创建人  : 吴绪森
 * 创建时间：2019-10-12
 * 修改人  ：
 * 修改时间：
 * 修改备注：
 * 版    本： V1.0
 */

public class FuntionTest {


    public static void main(String[] args) {

        User a = User.builder().age(15).name("a").build();
        User b = User.builder().age(16).name("b").build();
        User c = User.builder().age(17).name("c").build();
        User d = User.builder().age(18).name("d").build();


        List<User> list = Lists.newArrayList(a,b,c,d);


        List<User> users = testPredicate(list, e -> {
            return e.getAge() == 15;
        });

        System.out.println(users.size());


    }

    public static List<User> testPredicate(List<User> users, Predicate<User> predicate) {
        List<User> tempUsers = new ArrayList<>();
        for (User user : users) {
            boolean test = predicate.test(user);
            System.out.println(test);
            if (test) {
                tempUsers.add(user);
            }
        }
        return tempUsers;
    }
}

@Data
@Builder
class User{

    private String name;
    private int age;



}
