package com.wxs.algorithm.week07;

import javafx.util.Pair;

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

public class ladderLength127 {


    public static void main(String[] args) {

        // pair 使用的好处是 只存一个键值对，通过方法直接拿到key value
        Pair<String, String> s = new Pair<>("a", "b");


        String beginWord = "hit", endWord = "cog";
        String[] wordList = {"hot", "dot", "dog", "lot", "log", "cog"};

        ladderLength127 ladderLength127 = new ladderLength127();

        int i = ladderLength127.ladderLength3(beginWord, endWord, Arrays.asList(wordList));

        System.out.println(i);

    }


    /**
     * 思路：
     * 1、先遍历字段，让每个字典里面的单词 ，任意字母用星号代替如 dog -> *og ,星号代替完后，让*字母为key放入map中
     * <p>
     * 2、创建queue，当queue不为空时，拿出字母，用星号代替每个字母，在map 中查询，
     * 如果查到level+1，如果查到的单词等于endword表明找到了该单词
     * <p>
     * 注意：为了防止查询循环，需要创建map用来标识已经访问过的单词
     *
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {


        int len = beginWord.length();

        HashMap<String, List<String>> map = new HashMap<>();

        wordList.forEach(e -> {
            for (int i = 0; i < 3; i++) {
                String newWord = e.substring(0, i) + "*" + e.substring(i + 1, len);
                List<String> words = map.getOrDefault(newWord, new ArrayList<>());
                words.add(e);
                map.put(newWord, words);
            }
        });


        Queue<Pair<String, Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(beginWord, 1));

        Map<String, Boolean> visited = new HashMap<>();
        visited.put(beginWord, true);

        while (!queue.isEmpty()) {

            Pair<String, Integer> remove = queue.remove();

            Integer level = remove.getValue();
            String key = remove.getKey();


            for (int i = 0; i < 3; i++) {

                String newKey = key.substring(0, i) + "*" + key.substring(i + 1, len);

                List<String> wordlist = map.getOrDefault(newKey, new ArrayList<>());

                for (String s : wordlist) {

                    if (endWord.equals(s)) {
                        return level + 1;
                    }

                    if (visited.get(s)) continue;

                    visited.put(s, true);
                    queue.add(new Pair<>(s, level + 1));

                }
            }
        }

        return 0;
    }


    public int ladderLength1(String beginWord, String endWord, List<String> wordList) {

        if (!wordList.contains(endWord)) {
            return 0;
        }

        // Set<String> visited = new HashSet<>();
        boolean[] visited = new boolean[wordList.size()];

        Queue<String> queue = new LinkedList<>();

        queue.add(beginWord);


        int idx = wordList.indexOf(beginWord);
        if (idx != -1) {

            visited[idx] = true;
        }

        int level = 0;

        while (queue.size() > 0) {
            level++;

            // size 必须放到 while 内层，当局部变量，用来标示一层有多少单词
            int size = queue.size();

            for (int i = 0; i < size; i++) {

                String start = queue.poll();

                for (String s : wordList) {

                    int i1 = wordList.indexOf(s);

                    if (visited[i1]) continue;

                    //  if(visited.contains(s))continue;


                    //  一步是否能转换
                    if (!canConvert(start, s)) continue;


                    if (endWord.equals(s)) {
                        return level + 1;
                    }
                    queue.add(s);
                    // visited.add(s);
                    visited[i1] = true;

                }


            }
        }


        return 0;


    }

    private boolean canConvert(String start, String word) {

        // 根据题意单词长度都一样，此处判断很多余
        if (start.length() != word.length()) return false;

        // 记录单词差异数
        int count = 0;

        for (int i = 0; i < start.length(); i++) {
            if (start.charAt(i) != word.charAt(i)) {
                count++;
                if (count > 1) {
                    return false;
                }
            }

        }
        return true;
    }


    /**
     * bfs  思路
     * 1、 创建队列 用来保存当前层的数据
     * 2、 使用set用来存储以访问的点，防止循环访问 并记录每一层的len
     * 3、 获得队列当前层的所有节点，遍历。 ，
     * 遍历时要拿所有的字典遍历，判断弹出的节点与字段遍历的节点是否存在一次变动相同的情况，
     * 如果超过一次，continue，
     * 如果只需一次 判断endword 与 字典遍历的节点是否相等，如果相等 len+1 返回。
     * 4、 如果不相等，则放入队列，且放入set表示已经访问过
     *
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public int ladderLength2(String beginWord, String endWord, List<String> wordList) {

        Queue<String> queue = new LinkedList<>();

        Set<String> visited = new HashSet<>();

        int len = 0;

        queue.add(beginWord);
        visited.add(beginWord);

        while (!queue.isEmpty()) {
            // 队列当前层数
            int size = queue.size();

            len++;

            while (size-- > 0) {

                String curr = queue.poll();

                for (String next : wordList) {

                    if (visited.contains(next)) continue;

                    if (!canTranser(curr,next)) continue;

                    if (endWord.equals(next)) {
                        return len + 1;
                    }
                    visited.add(next);
                    queue.add(next);
                }
            }
        }
        return 0;
    }

    private boolean canTranser(String curr, String next) {

        int count = 0;
        for (int i = 0; i < curr.length(); i++) {

            if(curr.charAt(i) != next.charAt(i)){
                count ++;
                if(count > 1){
                    return false;
                }
            }


        }
        return true;
    }


    /**
     * 双向bfs 使用两个set ，在循环体内创建一个set用来存放当前层所有的单词
     *
     * 注意，list contains 时间复杂度O(n) set contains 时间复杂度O(1)
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public int ladderLength3(String beginWord, String endWord, List<String> wordList) {

        if (!wordList.contains(endWord)) {
            return 0;
        }

        Set<String> startSet = new HashSet<>(),
                endSet = new HashSet<>(),
                visited = new HashSet<>();

        Set<String> dict = new HashSet<>(wordList);
        int len = 0;
        startSet.add(beginWord);
        endSet.add(endWord);


        while (!startSet.isEmpty() && !endSet.isEmpty()){

            len++;
            // 使用当前层最小的set
            if(startSet.size() > endSet.size()){
                Set<String> change = startSet;
                startSet = endSet;
                endSet = change;
            }

            Set<String> tempSet = new HashSet<>();

            for (String word : startSet) {

                char[] chars = word.toCharArray();

                for (int i = 0; i < chars.length; i++) {
                    for (char j = 'a'; j <= 'z'; j++) {
                        char old = chars[i];
                        chars[i] = j;
                        String target = String.valueOf(chars);
                        if(endSet.contains(target)){
                            return len+1;
                        }
                        if(!visited.contains(target)&& dict.contains(target)){
                            tempSet.add(target);
                            visited.add(target);
                        }
                        chars[i] = old;

                    }
                }
            }

            startSet = tempSet;
        }
        return 0;
    }



    public int ladderLength4(String beginWord, String endWord, List<String> wordList) {


        Set<String> dict = new HashSet<>(wordList),startSet = new HashSet<>(),endSet = new HashSet<>(),visited = new HashSet<>();

        if(!dict.contains(endWord)){
            return 0;
        }


        startSet.add(beginWord);
        endSet.add(endWord);
        int len = 0;
        while (!startSet.isEmpty() && !endSet.isEmpty()){
            len ++;
            if(startSet.size() > endSet.size()){
                Set<String> change = startSet;
                startSet = endSet;
                endSet = change;
            }

            Set<String> tempSet = new HashSet<>();
            for (String word : startSet) {
                char[] chars = word.toCharArray();
                for (int i = 0; i < chars.length; i++) {
                    for (char j = 'a'; j <= 'z'; j++) {
                        char old = chars[i];
                        chars[i] = j;
                        String target = String.valueOf(chars);

                        if(endSet.contains(target)){
                            return len + 1;
                        }


                        if(!visited.contains(target) && dict.contains(target)){
                            visited.add(target);
                            tempSet.add(target);
                        }
                        chars[i] = old;
                    }
                }
            }
            startSet = tempSet;
        }
        return 0;
    }



}
