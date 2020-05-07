package com.wxs.algorithm.week04;

import javafx.util.Pair;

import java.util.*;

/**
 * 类描述  ：
 * 创建人  : 吴绪森
 * 创建时间：2020-04-04
 * 修改人  ：
 * 修改时间：
 * 修改备注：
 * 版    本： V1.0
 */

public class ladderLength127 {


    public static void main(String[] args) {


        String beginWord = "hit", endWord = "cog";
        String[] wordList = {"hot", "dot", "dog", "lot", "log", "cog"};

        ladderLength127 ladderLength127 = new ladderLength127();

        ladderLength127.ladderLength(beginWord, endWord, Arrays.asList(wordList));


    }

    List<String> aa = new ArrayList<>();

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {


        int len = beginWord.length();


        // 用来处理字段
        Map<String, List<String>> all = new HashMap<>();

        wordList.forEach(e -> {

            for (int i = 0; i < len; i++) {
                String newWord = e.substring(0, i) + "*" + e.substring(i + 1, len);
                List<String> words = all.getOrDefault(newWord, new ArrayList<>());
                words.add(e);
                all.put(newWord, words);
            }

        });


        // 广度优先 ，按层查找，第一个匹配是层数就是最短路径
        Queue<Pair<String, Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(beginWord, 1));

        // 为了防止循环访问，表示已经访问过的节点
        HashMap<String, Boolean> visited = new HashMap<>();
        visited.put(beginWord, true);


        while (!queue.isEmpty()) {

            Pair<String, Integer> node = queue.remove();
            String word = node.getKey();
            Integer level = node.getValue();

            // 查找字典，获得下一步的单词

            for (int i = 0; i < len; i++) {

                String currWord = word.substring(0, i) + "*" + word.substring(i + 1, len);

                // 获得模糊匹配的所有单词
                List<String> list = all.getOrDefault(currWord, new ArrayList<>());


                for (String dicWord : list) {


                    if (endWord.equals(dicWord)) {
                        return level + 1;
                    }

                    if (!visited.containsKey(dicWord)) {

                        visited.put(dicWord, true);

                        queue.add(new Pair<>(dicWord, level + 1));


                    }


                }


            }


        }


        return 0;
    }


}
