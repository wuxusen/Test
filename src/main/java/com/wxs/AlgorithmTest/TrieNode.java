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
class Trie {


    private TrieNode root;


    public Trie() {
        root = new TrieNode();
    }


    public void insert(String word) {

        TrieNode node = root;

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);

            if (!node.isContain(c)) {
                node.put(c, new TrieNode());
            }

            node = node.get(c);

        }
        node.setEnd();

    }


    public boolean search(String word){
       TrieNode node =  searchPrefix(word);
        return node != null && node.isEnd();
    }


    public boolean startWith(String prefix){
        return searchPrefix(prefix) != null;
    }


    public TrieNode searchPrefix(String word){


        TrieNode node = root;

        for(int i = 0 ; i < word.length(); i++){
            if(node.isContain(word.charAt(i))){
                node = node.get(word.charAt(i));
            }else {
                return null;
            }
        }
        return node;

    }


}


class TrieNode {

    private TrieNode[] links;

    private boolean isEnd;


    public TrieNode() {
        links = new TrieNode[26];
    }


    boolean isContain(char ch) {

        return links[ch - 'a'] != null;
    }

    void put(char ch, TrieNode node) {
        links[ch - 'a'] = node;
    }

    TrieNode get(char ch) {
        return links[ch - 'a'];
    }


    void setEnd() {
        this.isEnd = true;
    }

    boolean isEnd() {
        return this.isEnd;
    }

}
