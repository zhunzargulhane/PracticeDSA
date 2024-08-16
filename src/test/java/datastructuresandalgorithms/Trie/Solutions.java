package datastructuresandalgorithms.Trie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }

    public Node(int v) {
        this.val = v;
    }
}


public class Solutions {
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        Node copy = new Node(node.val);
        Node[] visited = new Node[101];
        dfs(node, copy, visited);
        for (int i = visited.length; i >= 0; i++) {
            if (visited[i] != null) {
                copy.neighbors.add(visited[i]);
                break;
            }
        }
        return copy;
    }

    public void dfs(Node node, Node copy, Node[] visited) {
        visited[copy.val] = copy;
        for (int i = 0; i < node.neighbors.size(); i++) {
            Node adjNode = node.neighbors.get(i);
            if (visited[adjNode.val] == null) {
                Node newNode = new Node(adjNode.val);
                dfs(adjNode, newNode, visited);
                copy.neighbors.add(newNode);
            } else {
                copy.neighbors.add(adjNode);
            }
        }
    }

    public static void main(String[] args) {
        String s = "abcde";
        String s1 = "ace";
        Solutions1 solutions = new Solutions1();
        String[] words = {"a", "bb", "acd", "ace"};
        List<String> dictionary = new ArrayList<String>();
        dictionary.add("catt");
        dictionary.add("cat");
        dictionary.add("bat");
        dictionary.add("rat");
       // System.out.println(solutions.replaceWords(dictionary, "the cattle was rattled by the battery"

        //));
        Trie trie = new Trie();
    }


    public int numSubsequence(String originalWord, String[] words) {
        HashMap<Character, ArrayList<Integer>> hashMap = new HashMap<Character, ArrayList<Integer>>();
        ArrayList<Integer> list;
        int count = 0;
        for (int i = 0; i < originalWord.length(); i++) {
            if (hashMap.containsKey(originalWord.charAt(i)))
                list = hashMap.get(originalWord.charAt(i));
            else
                list = new ArrayList<Integer>();
            list.add(i);
            hashMap.put(originalWord.charAt(i), list);
        }
        for (String word : words) {
            if (isValid(hashMap, word) == true)
                count++;
        }
        return count;
    }

    public boolean isValid(HashMap<Character, ArrayList<Integer>> hashMap, String word) {
        int previous = Integer.MIN_VALUE;
        for (int i = 0; i < word.length(); i++) {
            char character = word.charAt(i);
            if (!hashMap.containsKey(character)) return false;
            ArrayList<Integer> list = hashMap.get(character);
            boolean flag = false;
            for (int num : list) {
                if (num > previous) {
                    previous = num;
                    flag = true;
                    break;
                }
            }
            if (flag == false) return false;
        }
        return true;
    }


    public boolean isValid(String originalWord, String word, int index1, int index2) {
        while (index1 < originalWord.length() && index2 < word.length()) {
            if (originalWord.charAt(index1) == word.charAt(index2)) {
                index1++;
                index2++;
            } else {
                index1++;
            }
        }
        if (index2 == word.length()) return true;
        else return false;
    }


    public String replaceWords(List<String> dictionary, String sentence) {
        String[] stringArray = sentence.split("\\s");
        StringBuilder sb = new StringBuilder();
        ArrayList<String> list;
        for (String word : stringArray) {
            list = new ArrayList();
            for (int i = 0; i < dictionary.size(); i++) {
                if (word.startsWith(dictionary.get(i))) {
                    list.add(dictionary.get(i));
                    break;
                }
            }
            if (list.size() == 1) {
                sb.append(list.get(0) + " ");
            }
            if (list.size() > 1) {
                int min = Integer.MAX_VALUE;
                String minWord = "";
                for (int j = 0; j < list.size(); j++) {
                    if (list.get(j).length() < min) {
                        min = list.get(j).length();
                        minWord = list.get(j);
                    }
                }
                sb.append(minWord + " ");
            }
            if (list.isEmpty()) sb.append(word + " ");
        }
        return sb.deleteCharAt(sb.length() - 1).toString();
    }


    public String replaceWords1(List<String> dictionary, String sentence) {
        for (int i = 0; i < dictionary.size(); i++) {
            insertWord(dictionary.get(i));
        }
        return null;
    }

    public void insertWord(String word) {

        // TrieNode temp = root;
        char[] character = word.toCharArray();
        for (int i = 0; i < character.length; i++) {
            int index = character[i] - 'a';
        }

    }


}
