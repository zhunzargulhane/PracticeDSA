package datastructuresandalgorithms.binaryTree;

import com.sun.org.apache.bcel.internal.classfile.Code;

public class Codec {
    private TreeNode root;

    private static class TreeNode {
        private TreeNode left;
        private TreeNode right;
        private final int data;

        TreeNode(int data) {
            this.data = data;
        }
    }

    String data = "";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        dfs11(root);
        return data;
    }

    public TreeNode dfs11(TreeNode root) {
        if (root == null)
            return null;
        data = data + root.data;
        dfs11(root.left);
        dfs11(root.right);
        return root;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.isEmpty())
             return null;
        int[] preorder = new int[data.length()];
        for (int i = 0; i < data.length(); i++)
            preorder[i] = data.charAt(i)-'0';
        return createBSTFromArray(preorder, 0, preorder.length - 1);
    }

    public TreeNode createBSTFromArray(int[] preorder, int left, int right) {
        if (left > right)
            return null;
        TreeNode root = new TreeNode(preorder[left]);
        int i;
        for (i = left; i <= right; i++) {
            if (preorder[i] > root.data) {
                break;
            }
        }
        root.left = createBSTFromArray(preorder, left + 1, i - 1);
        root.right = createBSTFromArray(preorder, i, right);
        return root;
    }

    public TreeNode createBinaryTree(){
        TreeNode first = new TreeNode(2);
        TreeNode second = new TreeNode(1);
        TreeNode third = new TreeNode(3);
        root=first;
        first.left=second;
        first.right=third;
        return root;
    }

    public static void main(String[] args) {
        Codec codec = new Codec();
        codec.createBinaryTree();
        String tree=codec.serialize(codec.root);
        codec.deserialize(tree);

    }

}
