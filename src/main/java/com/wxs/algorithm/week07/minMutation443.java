package com.wxs.algorithm.week07;

import java.util.*;

/**
 * 类描述  ：
 * 创建人  : 吴绪森
 * 创建时间：2020-04-29
 * 修改人  ：
 * 修改时间：
 * 修改备注：
 * 版    本： V1.0
 */

public class minMutation443 {

    public static void main(String[] args) {

        String start = "AAAAACCC";
        String end = "AACCCCCC";
        String[] bank = {"AAAACCCC", "AAACCCCC", "AACCCCCC"};
        minMutation443 minMutation443 = new minMutation443();

        int i = minMutation443.minMutation(start, end, bank);
        System.out.println(i);

    }

    public int minMutation(String start, String end, String[] bank) {

        if (bank.length == 0) {
            return -1;
        }


        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        queue.add(start);
        visited.add(start);

        int len = 0;
        while (!queue.isEmpty()) {

            len++;
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                String curr = queue.poll();

                for (String bankDNA : bank) {

                    if (visited.contains(bankDNA)) continue;
                    if (!canTranser(curr, bankDNA)) continue;

                    if (end.equals(bankDNA)) {
                        return len;
                    }

                    visited.add(bankDNA);
                    queue.add(bankDNA);
                }
            }
        }
        return 0;
    }

    private boolean canTranser(String curr, String bankDNA) {

        int count = 0;
        for (int i = 0; i < curr.length(); i++) {
            if (curr.charAt(i) != bankDNA.charAt(i)) {
                count++;
                if (count > 1) {
                    return false;
                }
            }

        }


        return true;
    }


    public int minMutation1(String start, String end, String[] bank) {

        if(bank.length == 0){
            return -1;
        }

        Set<String> bankSet = new HashSet<String>(Arrays.asList(bank)),
                startSet = new HashSet<>(),
                endSet = new HashSet<>(),
                visited = new HashSet<>();



        if(!bankSet.contains(end))return -1;

        startSet.add(start);
        endSet.add(end);
        visited.add(start);
        visited.add(end);

        char[] seq = {'A','C','G','T'};

        int len = 0;

        while (!startSet.isEmpty() && !endSet.isEmpty()){

            len++;
            if(startSet.size() > endSet.size()){
                Set<String> change = startSet;
                startSet = endSet;
                endSet = change;
            }


            Set<String> tempSet = new HashSet<>();
            for (String s : startSet) {

                char[] chars = s.toCharArray();

                for (int i = 0; i < chars.length; i++) {

                    for (int j = 0; j < seq.length; j++) {

                        char old = chars[i];
                        chars[i] = seq[j];

                        String target = String.valueOf(chars);

                        if(endSet.contains(target)){
                            return len;
                        }

                        if(!visited.contains(target) && bankSet.contains(target)){
                            visited.add(target);
                            tempSet.add(target);
                        }

                        chars[i] = old;

                    }
                }
            }

            startSet = tempSet;
        }

        return -1;
    }

}
