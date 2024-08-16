package datastructuresandalgorithms.Trie;

public class MaximumXOR {

    private TrieNode root;

    public MaximumXOR() {
        root = new TrieNode();
    }

    private class TrieNode {
        private TrieNode left;
        private TrieNode right;

        public TrieNode() {

        }
    }

    public int maximumXor(int[] nums) {
        TrieNode temp = root;
        int maxResult = 0;
        for (int i = 0; i < nums.length; i++) {
            insertNumber(nums[i], temp);
        }
        for (int i = 0; i < nums.length; i++) {
            int number = nums[i];
            maxResult = Math.max(findMaxXOR(number, root), maxResult);
        }
        return maxResult;
    }

    public void insertNumber(int number, TrieNode temp) {
        for (int i = 31; i >= 0; i--) {
            int iBit = (number >> i) & 1;
            if (iBit == 0) {
                if (temp.left == null) {
                    temp.left = new TrieNode();
                }
                temp = temp.left;
            } else {
                if (temp.right == null) {
                    temp.right = new TrieNode();
                }
                temp = temp.right;
            }
        }
    }

    public int findMaxXOR(int number, TrieNode root) {
        double res = 0;
        TrieNode temp = root;
        for (int i = 31; i >= 0; i--) {
            int iBit = (number >> i) & 1;
            if (iBit == 0) {
                if (temp.right != null) {
                    res = res + 1 * Math.pow(2, i);  //on the fly we are calcualting.
                    temp = temp.right;
                } else {
                    res = res + 0 * Math.pow(2, i);
                    temp = temp.left;
                }
            } else {
                if (temp.left != null) {
                    res = res + 0 * Math.pow(2, i);
                    temp = temp.left;
                } else {
                    res = res + 1 * Math.pow(2, i);
                    temp = temp.right;
                }
            }
        }
        return (int) res;
    }

}
