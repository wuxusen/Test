package com.wxs.algorithm1.week01;

import java.util.*;

/**
 * 类描述  ：
 * 创建人  : 吴绪森
 * 创建时间：2020-03-12
 * 修改人  ：
 * 修改时间：
 * 修改备注：
 * 版    本： V1.0
 */

public class ThreeSum15 {


    public static void main(String[] args) {
        int[] arr = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> lists = threeSum2(arr);
        System.out.println(lists);

    }


    // 时间复杂度为 O(n^3) 空间复杂度为
    public List<List<Integer>> threeSum(int[] nums) {

        if (nums == null || nums.length <= 2) {
            return Collections.emptyList();
        }
        Arrays.sort(nums);

        Set<List<Integer>> list = new LinkedHashSet<>();

        for (int i = 0; i < nums.length - 2; i++) {

            for (int j = i + 1; j < nums.length - 1; j++) {

                for (int k = j + 1; k < nums.length; k++) {

                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> indexs = Arrays.asList(nums[i], nums[j], nums[k]);
                        list.add(indexs);
                    }

                }

            }
        }

        return new ArrayList<>(list);
    }


    // 时间复杂度为 O(n^3) 空间复杂度为
    public List<List<Integer>> threeSum1(int[] nums) {

        if (nums.length <= 2 || nums == null) {
            return Collections.emptyList();
        }
        Arrays.sort(nums);

        List<List<Integer>> list = new ArrayList<>();
        for (int k = 0; k < nums.length - 2; k++) {
            int i = k + 1;
            int j = nums.length - 1;

            if (nums[k] > 0) {
                break;
            }
            if (nums[k] == nums[k - 1]) continue;

            while (i < j) {

                int sum = nums[k] + nums[j] + nums[i];

                if (sum > 0) {
                    while (i < j && nums[j] == nums[--j]) ;

                } else if (sum < 0) {

                    while (i < j && nums[i] == nums[++i]) ;
                } else {

                    List<Integer> sumList = Arrays.asList(nums[k], nums[i], nums[j]);
                    while (i < j && nums[j] == nums[--j]) ;
                    while (i < j && nums[i] == nums[++i]) ;


                    list.add(sumList);
                }
            }
        }
        return list;
    }


    public static List<List<Integer>> threeSum2(int[] nums) {

        List<List<Integer>> list = new ArrayList<>();

        if (nums == null || nums.length < 2) {
            return list;
        }

        Arrays.sort(nums);

        for (int k = 0; k < nums.length - 2; k++) {

            int i = k + 1;
            int j = nums.length - 1;
            if (nums[k] > 0) break;
            if (k > 0 && nums[k] == nums[k - 1]) continue;

            while (i < j) {

                int sum = nums[k] + nums[i] + nums[j];

                if (sum > 0) {
                    while (i < j && nums[j] == nums[--j]) ;
                } else if (sum < 0) {
                    while (i < j && nums[i] == nums[++i]) ;
                } else {
                    List<Integer> sumList = Arrays.asList(nums[k], nums[i], nums[j]);
                    list.add(sumList);
                    while (i < j && nums[j] == nums[--j]) ;
                    while (i < j && nums[i] == nums[++i]) ;
                }

            }

        }

        return list;


    }


    // 排序 去重
    public static List<List<Integer>> threeSum4(int[] nums) {

        if (nums == null || nums.length < 3) {
            return Collections.emptyList();
        }

        Arrays.sort(nums);

        Set<List<Integer>> list = new LinkedHashSet<>();
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {

                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> indexs = Arrays.asList(nums[i], nums[j], nums[k]);
                        list.add(indexs);

                    }

                }
            }

        }


        return new ArrayList<>(list);
    }


    // 三个指针   k = 0 ,i = k + 1, j = length - 1
    public static List<List<Integer>> threeSum5(int[] nums) {


        if (nums == null || nums.length < 3) {
            return Collections.emptyList();
        }

        Arrays.sort(nums);


        List<List<Integer>> list = new ArrayList<>();

        for (int k = 0; k < nums.length; k++) {

            int i = k + 1;
            int j = nums.length - 1;

            if (nums[k] > 0) {
                break;
            }

            if (nums[k] == nums[k - 1]) {
                continue;
            }

            while (i < j) {
                int sum = nums[k] + nums[i] + nums[j];
                if (sum > 0) {
                    while (i < j && nums[j] == nums[--j]) ;
                } else if (sum < 0) {
                    while (i < j && nums[i] == nums[++i]) ;
                } else {

                    list.add(Arrays.asList(nums[k], nums[i], nums[j]));
                    while (i < j && nums[j] == nums[--j]) ;
                    while (i < j && nums[i] == nums[++i]) ;

                }

            }

        }

        return list;
    }


}
