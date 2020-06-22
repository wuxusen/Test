package com.wxs.AlgorithmTest;

/**
 * 类描述  ：
 * 创建人  : 吴绪森
 * 创建时间：2020-06-19
 * 修改人  ：
 * 修改时间：
 * 修改备注：
 * 版    本： V1.0
 */


class Trie1 {


    private TrieNode1 root;


    public Trie1() {
        root = new TrieNode1();
    }


    public void insert(String word) {


        TrieNode1 node1 = root;


        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);

            if (!node1.isContains(c)) {
                node1.put(c, new TrieNode1());
            }

            node1 = node1.get(c);

        }

        node1.isEnd();

    }


    public boolean search(String word){

        TrieNode1 node1 = searchPrefix(word);

        return node1 != null && node1.isEnd();
    }



    public boolean search1(String word){
        return match(word.toCharArray(),0,root);
    }

    private boolean match(char[] array, int level, TrieNode1 root) {

        if(level == array.length){
            TrieNode1 node1 = root.get(array[level]);
            return node1 != null && node1.isEnd();
        }

        if(array[level] != '.'){
            return root.get(array[level]) != null && match(array,level + 1,root.get(array[level]));
        }else {

            for(int i = 0 ; i < 26; i++){
                if(root.get(array[i]) != null){
                    if(match(array,level+1,root.get(array[i]))){
                        return true;
                    }
                }
            }


        }


        return false;
    }


    public boolean searchStartWith(String word){
        return searchPrefix(word) != null;
    }



    public TrieNode1 searchPrefix(String word){

        TrieNode1 node = root;

        for(int i = 0 ; i < word.length() ; i++){
            char c = word.charAt(i);
            if(node.isContains(c)){
                node = node.get(c);
            }else {
                return null;
            }
        }

        return node;
    }


}


public class TrieNode1 {


    private TrieNode1[] links;

    private boolean isEnd;


    public TrieNode1() {
        links = new TrieNode1[26];
    }


    public boolean isContains(char ch) {

        return links[ch - 'a'] != null;
    }

    public void put(char ch, TrieNode1 node1) {
        links[ch - 'a'] = node1;
    }


    public TrieNode1 get(char ch) {
        return links[ch - 'a'];
    }


    public void setEnd() {
        this.isEnd = true;
    }

    public boolean isEnd() {
        return this.isEnd;
    }


}
