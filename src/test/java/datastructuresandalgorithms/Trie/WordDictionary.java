package datastructuresandalgorithms.Trie;

class WordDictionary {
    public TrieNode root;
    private class TrieNode {
        private TrieNode[] children;
        private boolean isWord;

        TrieNode() {
            this.children = new TrieNode[26];
            isWord = false;
        }
    }
    public WordDictionary() {
        this.root = new TrieNode();
    }

    public void addWord(String word) {
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
        return dfs(word,0,temp);
    }

    public boolean dfs(String word,int index,TrieNode temp){
        if(temp==null) return false;
        if(index==word.length()) return temp.isWord;
        if(word.charAt(index)=='.'){
            for(int i=0;i<26;i++){
                if(temp.children[i]!=null){
                    temp=temp.children[i];
                   // index++;
                    if(dfs(word,index+1,temp)==true) return true;
                }
            }
        }else{
            int ind = word.charAt(index)-'a';
            if(dfs(word,index+1,temp.children[ind])==true) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("a");
        wordDictionary.addWord("ab");
        wordDictionary.search(".a");
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */

