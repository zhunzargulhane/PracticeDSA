package datastructuresandalgorithms.Trie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class LeetCode648 {
    public TrieNode root;
    public LeetCode648(){
        this.root=new TrieNode();
    }
    private class TrieNode{
        TrieNode[] children;
        boolean isWord;
        public TrieNode(){
            this.children = new TrieNode[26];
            isWord=false;
        }
    }
    public String replaceWords(List<String> dictionary, String sentence) {
        for(String word:dictionary){
            insert(word);
        }
        String[] words = sentence.trim().split(" ");
        for(int i=0;i<words.length;i++){
            StringBuffer sb = new StringBuffer();
            TrieNode temp = root;
            Boolean flag = false;
            for(int j=0;j<words[i].length();j++){
                int ind = words[i].charAt(j)-'a';
                if(temp.children[ind]!=null){
                    temp=temp.children[ind];
                    sb.append(words[i].charAt(j));
                }
                else {
                    if(temp.isWord){
                        flag=true;
                    }
                    break;
                }
            }
            if(flag)
                words[i]=sb.toString();
        }
        return Arrays.toString(words);
    }

    public void insert(String s){
        char[] chars= s.toCharArray();
        TrieNode temp =root;
        for(int i=0;i<chars.length;i++){
            int index = chars[i]-'a';
            if(temp.children[index]==null)
                temp.children[index]=new TrieNode();
            temp=temp.children[index];
        }
        temp.isWord=true;
    }

    public static void main(String[] args) {
        int index = 97+22;
        char ch = (char) index;
        System.out.println(ch);
      /*  List<String> dictionary = new ArrayList();
        dictionary.add("cat");
        dictionary.add("bat");
        dictionary.add("rat");
        LeetCode648 leetCode648 = new LeetCode648();
        leetCode648.replaceWords(dictionary,"the cattle was rattled by the battery");*/
    }
}
