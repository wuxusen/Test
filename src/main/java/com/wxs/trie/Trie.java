package com.wxs.trie;

/**
 * 类描述  ：
 * 创建人  : 吴绪森
 * 创建时间：2019-08-27
 * 修改人  ：
 * 修改时间：
 * 修改备注：
 * 版    本： V1.0
 */

public class Trie {


    public static void main(String[] args) {

        Trie trie = new Trie();

        char[] text = {'h','e','l','l','o'};
        trie.insert(text);
        char[] text2 = {'h','e','r'};
        trie.insert(text2);
        char[] text3 =  {'h','e','l','l','o'};

        boolean b = trie.find(text3);

        System.out.println("是否存在 >>>>"+b);


    }


    private TrieNode root = new TrieNode('/'); // 存储无意义字符

    // 往Trie树中插入一个字符串
    public void insert(char[] text) {
        TrieNode p = root;
        for (int i = 0; i < text.length; ++i) {
            int index = text[i] - 'a';
            if (p.children[index] == null) {
                TrieNode newNode = new TrieNode(text[i]);
                p.children[index] = newNode;
            }
            p = p.children[index];
        }
        p.isEndingChar = true;
    }


    public boolean find(char[] pattern){

        TrieNode r = root;

        for (int i = 0; i < pattern.length; i++) {

           int index = pattern[i] - 'a';

            TrieNode child = r.children[index];

            if(child == null){
                return false;
            }else {
                r = child;
            }
        }
        return r.isEndingChar;

    }


    public class TrieNode {
        public char data;
        public TrieNode[] children = new TrieNode[26];
        public boolean isEndingChar = false;

        public TrieNode(char data) {
            this.data = data;
        }
    }
}
