package datastructuresandalgorithms.binaryTree;

import java.util.Collections;

public class TwoBinaryTrees {

    private TreeNode root1;
    private TreeNode root2;

    private static class TreeNode {
        private int data;
        private TreeNode left;
        private TreeNode right;

        TreeNode(int data) {
            this.data = data;
        }
    }

    public void createFirstBinaryTree() {
        TreeNode first = new TreeNode(1);
        TreeNode second = new TreeNode(2);
        //TreeNode third = new TreeNode(3);
        //TreeNode fourth = new TreeNode(5);
        root1 = first;
        first.left = second;
        // first.right = third;
        //second.left = fourth;
    }

    public void createSecondBinaryTree() {
        TreeNode first = new TreeNode(1);
        TreeNode second = new TreeNode(2);
        //TreeNode third = new TreeNode(3);
        //TreeNode fourth = new TreeNode(5);
        root2 = first;
        //    first.left = second;
        first.right = second;
        //second.left = fourth;
    }

    public boolean isSameTree(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) return true;
        if (root1 == null || root2 == null) return false;
        if (isSameTree(root1.left, root2.left) == false)
            return false;
        if (root1.data != root2.data) return false;
        if (isSameTree(root1.right, root2.right) == false)
            return false;
        return true;
    }

    public static void main(String[] args) {
        TwoBinaryTrees twoBinaryTrees = new TwoBinaryTrees();
        twoBinaryTrees.createFirstBinaryTree();
        twoBinaryTrees.createSecondBinaryTree();
        //  twoBinaryTrees.mergeTrees(twoBinaryTrees.root1, twoBinaryTrees.root2);
        System.out.println(twoBinaryTrees.isSameTree(twoBinaryTrees.root1, twoBinaryTrees.root2));
    }

    TreeNode temp;

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 != null && root2 != null)
            root1.data = root1.data + root2.data;
        if (root1 == null)
            return root2;
        if (root2 == null)
            return root1;
        root1.left = mergeTrees(root1.left, root2.left);
        root1.right = mergeTrees(root1.right, root2.right);
        return root1;
    }
}
