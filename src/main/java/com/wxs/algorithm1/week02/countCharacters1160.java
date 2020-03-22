package com.wxs.algorithm1.week02;


/**
 * 类描述  ：
 * 创建人  : 吴绪森
 * 创建时间：2020-03-18
 * 修改人  ：
 * 修改时间：
 * 修改备注：
 * 版    本： V1.0
 */

public class countCharacters1160 {


    public static void main(String[] args) {

        String[] words = {"cat", "bt", "hat", "tree"};

        String chars = "atach";

        int i = countCharacters(words, chars);
        System.out.println(i);

    }

    public static int countCharacters1(String[] words, String chars) {

        int length = 0;

        int[] charsCount = counter1(chars);

        for (String word : words) {

            int[] wordCount = counter1(word);

            if (contains1(wordCount, charsCount)) {

                length += word.length();

            }
        }
        return length;
    }

    private static boolean contains1(int[] wordCount, int[] charsCount) {

        for (int i = 0; i < 26; i++) {
           if(charsCount[i] < wordCount[i]){
               return false;
           }

        }
        return true;
    }

    private static int[] counter1(String chars) {

        int[] count = new int[26];
        for (int i = 0; i < chars.length(); i++) {

            char c = chars.charAt(i);
            count[c - 'a']++;
        }
        return count;

    }






    public static int countCharacters(String[] words, String chars) {

        int len = 0;
        int[] charsCount = counter(chars);
        for (String word : words) {
            int[] wordCount = counter(word);

            if (contains(charsCount, wordCount)) {
                len += word.length();
            }

        }
        return len;

    }

    private static boolean contains(int[] charsCount, int[] wordCount) {


        for (int i = 0; i < 26; i++) {

            if (charsCount[i] < wordCount[i]) {

                return false;
            }

        }
        return true;


    }

    private static int[] counter(String word) {

        int[] count = new int[26];
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            count[c - 'a']++;
        }

        return count;

    }


}
