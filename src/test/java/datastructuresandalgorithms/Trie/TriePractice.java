package datastructuresandalgorithms.Trie;

public class TriePractice {
    public TrieNode root;

    public TriePractice() {
        this.root = new TrieNode();
    }

    private class TrieNode {
        private TrieNode[] children;
        private boolean isWord;

        TrieNode() {
            this.children = new TrieNode[26];
            isWord = false;
        }
    }

    public void insert(String word) {
        char[] charArray = word.toCharArray();
        TrieNode temp = root;
        for (int i = 0; i < charArray.length; i++) {
            int index = charArray[i] - 'a';
            if (temp.children[index] == null)
                temp.children[index] = new TrieNode();
            temp = temp.children[index];
        }
        temp.isWord = true;
    }

    public boolean search(String word) {
        TrieNode temp = root;
        char[] chars = word.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int index = chars[i] - 'a';
            if (temp.children[index] == null) return false;
            temp = temp.children[index];
        }
        if (temp.isWord) return true;
        return false;
    }

    public static void main(String[] args) {
        TriePractice triePractice = new TriePractice();
        triePractice.insert("cat");
        System.out.println(triePractice.search("dog"));

    }
}
