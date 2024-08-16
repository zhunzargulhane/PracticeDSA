package datastructuresandalgorithms.Trie;

public class Trie {
    private TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    }

    private class TrieNode {
        private TrieNode[] children;
        private boolean isWord;

        public TrieNode() {
            this.children = new TrieNode[26];
            this.isWord = false;
        }
    }

    public void insert(String word) {
        if (word == null || word.isEmpty())
            throw new IllegalArgumentException("Invalid Input");
        word = word.toLowerCase();
        char[] character = word.toCharArray();
        TrieNode temp = root;
        for (int i = 0; i < character.length; i++) {
            char charItem = character[i];
            int index = charItem - 'a';
            if (temp.children[index] == null)
                temp.children[index] = new TrieNode();
            temp = temp.children[index];
        }
        temp.isWord = true;
    }

    public void addWord(String word) {
        TrieNode temp = root;
        char[] characterArray = word.toCharArray();
        for (int i = 0; i < characterArray.length; i++) {
            char ch = characterArray[i];
            int index = ch - 'a';
            if (temp.children[index] == null)
                temp.children[index] = new TrieNode();
            temp = temp.children[index];
        }
        temp.isWord = true;
    }

    public boolean search(String word) {
        TrieNode temp = root;
        char[] character = word.toCharArray();
        for (int i = 0; i < character.length; i++) {
            char charItem = character[i];
            int index = charItem - 'a';
            if (temp.children[index] == null)
                return false;
            temp = temp.children[index];
        }
        return true;
    }

    public boolean searchdfs(String word) {
        TrieNode temp = root;
        return trieSearch1(word, 0, temp);
    }

    public boolean trieSearch(String word, int index, TrieNode temp) {
        if (temp == null) return false;
        if (index == word.length()) return temp.isWord;
        char character = word.charAt(index);
        if (character == '.') {
            for (int i = 0; i < 26; i++) {
                if (trieSearch(word, index + 1, temp.children[i]) == true)
                    return true;
            }
        } else {
            int ind = character - 'a';
            temp = temp.children[ind];
            if (trieSearch(word, index + 1, temp) == true) return true;
        }
        return false;
    }

    public boolean trieSearch1(String word, int index, TrieNode temp) {
        if(temp==null) return false;
        if(index==word.length()) return temp.isWord;
        char character = word.charAt(index);
        if (character == '.') {
            for (int i = 0; i < 26; i++) {
                if (temp.children[i] != null) {
                    if (trieSearch1(word, index + 1, temp.children[i]) == true)
                        return true;
                }
            }
        }else{
            int ind=character-'a';
            if(temp.children[ind]==null) return false;
            if (trieSearch1(word, index + 1, temp.children[ind]) == true)
                return true;
        }
        return false;
    }


    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.addWord("bat");
        String s="abcde";
        String s1="adc";
        System.out.println(s.contains(s1));
    }
}

