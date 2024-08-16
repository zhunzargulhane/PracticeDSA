package datastructuresandalgorithms.Trie;

public class MapSum {
    private TrieNode root;
    TrieNode temp = null;
    int finalSum = 0;

    public MapSum() {
        root = new TrieNode();
    }

    private class TrieNode {
        private TrieNode[] children;
        private boolean isWord;
        private int value;

        public TrieNode() {
            children = new TrieNode[26];
            isWord = false;
            value = 0;
        }
    }

    public void insert(String key, int val) {
        temp = root;
        char[] cArray = key.toCharArray();
        for (int i = 0; i < cArray.length; i++) {
            int index = cArray[i] - 'a';
            if (temp.children[index] == null)
                temp.children[index] = new TrieNode();
            temp = temp.children[index];

        }
        temp.value = val;
        temp.isWord = true;
    }

    public int sum(String prefix) {
        temp = root;
        for (int i = 0; i < prefix.length(); i++) {
            char character = prefix.charAt(i);
            int index = character - 'a';
            if (temp != null)
                temp = temp.children[index];
        }
        dfs(temp);
        return finalSum;
    }

    public void dfs(TrieNode temp) {
        if (temp == null) return;
        if (temp.isWord == true) {
            finalSum += temp.value;
        }
        for (int i = 0; i < 26; i++) {
            if (temp.children[i] != null) {
                dfs(temp.children[i]);
            }
        }
    }


    public static void main(String[] args) {
        MapSum mapSum = new MapSum();
        mapSum.insert("apple", 3);
        System.out.println(mapSum.sum("ap"));           // return 3 (apple = 3)
        mapSum.insert("app", 2);
        System.out.println(mapSum.sum("ap"));           // return 5 (apple + app = 3 + 2 = 5)
    }
}
