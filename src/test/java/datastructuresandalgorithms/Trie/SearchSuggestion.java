package datastructuresandalgorithms.Trie;

import java.util.ArrayList;
import java.util.List;

class SearchSuggestion {

    private TrieNode root;
    ArrayList<List<String>> lists = new ArrayList<List<String>>();
    ArrayList<String> list = new ArrayList<String>();

    public SearchSuggestion() {
        root = new TrieNode();
    }

    private class TrieNode {
        TrieNode[] children;
        boolean isWord;

        public TrieNode() {
            children = new TrieNode[26];
            isWord = false;
        }
    }

    public List<List<String>> suggestedProducts(String[] products, String word) {
        for (int i = 0; i < products.length; i++) {
            insertWord(products[i]);
        }
        String s = "";
        for (int i = 0; i < word.length(); i++) {
            String s1 = "";
            TrieNode temp = root;
            s=s+word.charAt(i);
            int index = 0;
            for (int j = 0; j < s.length(); j++) {
                index = word.charAt(j) - 'a';
                if (temp != null)
                    temp = temp.children[index];
            }
            for(int k=0;k<i;k++){
                s1=s1+word.charAt(k);
            }
            searchSuggestion(temp, s1, index);
            lists.add(list);
            list = new ArrayList();
        }
        return lists;
    }


    public void searchSuggestion(TrieNode temp, String s, int index) {
        if (temp == null) return;
        s = s + (char) (index + 'a');
        if (temp.isWord == true) {
            if (list.size() != 3) {
                list.add(s);
            }
        }
        for (int i = 0; i < 26; i++) {
            if (temp.children[i] != null)
                searchSuggestion(temp.children[i], s, i);
        }
    }

    public void insertWord(String word) {
        TrieNode temp = root;
        char[] character = word.toCharArray();
        for (int i = 0; i < character.length; i++) {
            int index = character[i] - 'a';
            if (temp.children[index] == null)
                temp.children[index] = new TrieNode();
            temp = temp.children[index];
        }
        temp.isWord = true;
    }

    public static void main(String[] args) {
        String[] products = {"mobile", "mouse", "moneypot", "monitor", "mousepad"};
        SearchSuggestion sg = new SearchSuggestion();
        System.out.println(sg.suggestedProducts(products, "mouse"));
    }
}
