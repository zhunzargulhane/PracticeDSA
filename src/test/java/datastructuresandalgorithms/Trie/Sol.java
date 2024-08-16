package datastructuresandalgorithms.Trie;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

class Sol {
    public TrieNode root;

    public Sol() {
        this.root = new TrieNode();
    }

    private class TrieNode {
        TrieNode[] children;
        boolean isWord;

        public TrieNode() {
            this.children = new TrieNode[26];
            this.isWord = false;
        }
    }

    public int numMatchingSubseq(String s, String[] words) {
        insertWord(s);
        int count = 0,j=0;
        HashMap<String,Integer> hashMap = new HashMap();
        for(int i=0;i<words.length;i++){
            hashMap.put(words[i],hashMap.getOrDefault(words[i],0)+1);
        }
        words = new String[hashMap.size()];
        for(String key:hashMap.keySet()){
            words[j++]=key;
        }
        for (int i = 0; i < words.length; i++) {
            TrieNode temp = root;
            if (search(words[i], temp, 0) == true)
                count++;
        }
        return count;
    }

    public boolean search(String word, TrieNode temp, int index) {
        if (index < word.length() && temp.isWord == true) return false;
        if (index == word.length()) return true;
        int ind = word.charAt(index) - 'a';
        for (int i = 0; i < 26; i++) {
            if (ind == i && temp.children[i] != null) {
                if (search(word, temp.children[i], index + 1) == true)
                    return true;
            } else if (temp.children[i] != null) {
                if (search(word, temp.children[i], index) == true)
                    return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String s="abcde";
        String[] words = {"a","bb","acd","ace"};
        Sol sol = new Sol();
        sol.insertWord(s);
        sol.numMatchingSubseq(s,words);
    }

    public void insertWord(String s) {
        char[] charArray = s.toCharArray();
        TrieNode temp = root;
        for (int i = 0; i < charArray.length; i++) {
            int index = charArray[i] - 'a';
            if (temp.children[index] == null)
                temp.children[index] = new TrieNode();
            temp = temp.children[index];
        }
        temp.isWord = true;

    }
}