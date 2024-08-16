package datastructuresandalgorithms.Trie;

import java.util.ArrayList;
import java.util.List;

class Solutions1 {
    public TrieNode root;

    public Solutions1() {
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

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> lists = new ArrayList();
        char[] chars = searchWord.toCharArray();

        for (String word : products)
            insert(word);
        for (int i = 0; i < chars.length; i++) {
            TrieNode temp = root;
            StringBuffer sb = new StringBuffer();
            List<String> list = new ArrayList();
            for (int j = 0; j <= i; j++) {
                int index = chars[j] - 'a';
                if (temp.children[index] != null)
                    temp = temp.children[index];
                sb = sb.append(chars[j]);
            }
            dfs(temp, list, sb);
            lists.add(list);
        }
        return lists;
    }

    public void dfs(TrieNode temp, List<String> list, StringBuffer sb) {
        if (temp == null) return;
        if (temp.isWord) {
            if (list.size() != 3)
                list.add(sb.toString());
        }
        for (int i = 0; i < 26; i++) {
            if (temp.children[i] != null) {
                char ch = (char) (97 + i);
                sb = sb.append(ch);
                dfs(temp.children[i], list, sb);
            }
        }
        sb.deleteCharAt(sb.length() - 1);
    }

    public void insert(String word) {
        TrieNode temp = root;
        char[] chars = word.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int index = chars[i] - 'a';
            if (temp.children[index] == null)
                temp.children[index] = new TrieNode();
            temp = temp.children[index];
        }
        temp.isWord = true;
    }


    public int fib(int n) {
        if(n<2) return n;
        int[] table = new int[n+1];
        table[0]=0;
        table[1]=1;
        for(int i=2;i<=n;i++){
            table[i]=table[i-1]+table[i-2];
        }
        return table[n];
    }


    public static void main(String[] args) {
        String[] products = {"bags", "baggage", "banner", "box", "cloths"};
        String searchWord = "bags";
        Solutions1 solutions1 = new Solutions1();
        //solutions1.suggestedProducts(products,searchWord);
        //3 - 011
        System.out.println((3 >> 0) & 1);
    }
}