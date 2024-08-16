package datastructuresandalgorithms.Trie;


class LargestString {
    public TrieNode root;

    public LargestString() {
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

    public String longestWord(String[] words) {
        String largestString = "";
        for (String word : words)
            insert(word);
        for (int i = 0; i < words.length; i++) {
            StringBuffer sb = new StringBuffer();
            TrieNode temp = root;
            char[] chars = words[i].toCharArray();
            for (int j = 0; j < chars.length; j++) {
                int index = chars[j] - 'a';
                if (temp.children[index].isWord) {
                    sb.append(chars[j]);
                    temp = temp.children[index];
                } else break;
            }
            if (sb.length() > largestString.length())
                largestString = sb.toString();
            else if (sb.length() == largestString.length()) {
                int j = largestString.compareTo(sb.toString());
                if (j < 0)
                    largestString = sb.toString();
            }
        }
        return largestString;
    }

    public void insert(String word) {
        char[] chars = word.toCharArray();
        TrieNode temp = root;
        for (int i = 0; i < chars.length; i++) {
            int index = chars[i] - 'a';
            if (temp.children[index] == null)
                temp.children[index] = new TrieNode();
            temp = temp.children[index];
        }
        temp.isWord = true;
    }

    public static void main(String[] args) {
        String[] words = {"a", "banana", "app", "appl", "ap", "apply", "apple"};
        LargestString largestString = new LargestString();
        largestString.longestWord(words);
    }
}
