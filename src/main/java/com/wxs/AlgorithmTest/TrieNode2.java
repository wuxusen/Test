package com.wxs.AlgorithmTest;

/**
 * 类描述  ：
 * 创建人  : 吴绪森
 * 创建时间：2020/6/21
 * 修改人  ：
 * 修改时间：
 * 修改备注：
 * 版    本： V1.0
 */

public class TrieNode2 {

    private TrieNode2[] links;
    private boolean isEnd;


    public TrieNode2(){
        links = new TrieNode2[26];
    }


    public void put(char ch, TrieNode2 node){
        links[ch - 'a'] = node;
    }


    public TrieNode2 get(char ch){
       return links[ch - 'a'];
    }


    public void setEnd(){
        this.isEnd = true;
    }

    public boolean isEnd(){
        return this.isEnd;
    }

    public boolean containKey(char ch){
        return links[ch - 'a'] != null;
    }


}

class Trie2{

    private TrieNode2 root;

    public Trie2(){
        root = new TrieNode2();
    }



    public TrieNode2 startWith(String word){
        TrieNode2 node = root;

        for(int i = 0 ;i < word.length();i ++){
            if( node.containKey(word.charAt(i))){
                node = node.get(word.charAt(i));
            }else {
                return null;
            }
        }

        return node;
    }

    public boolean search(String word){
        TrieNode2 node = startWith(word);
        return node != null && node.isEnd();
    }

    public void  insert(String word){

        TrieNode2 node = root;

        for(int i = 0; i < word.length(); i++){


            if(node.get(word.charAt(i)) == null){
               node.put(word.charAt(i),new TrieNode2());
            }
            node = node.get(word.charAt(i));
        }
        node.setEnd();
    }



}


