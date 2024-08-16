package datastructuresandalgorithms.binaryTree;

import java.util.*;

public class BinaryTreePractice {
    public TreeNode root;

    private static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int data) {
            this.data = data;
        }
    }

    public void recursivePreOrderTraversal(TreeNode root) {
        if (root == null)
            return;
        recursivePreOrderTraversal(root.left);
        recursivePreOrderTraversal(root.right);
        System.out.println(root.data);
    }

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        LinkedList<Integer> list = new LinkedList();
        List<List<Integer>> lists = new LinkedList();
        if (root == null) return lists;
        int sum = 0;
        recursive(root, list, lists, sum, target);
        return lists;
    }

    public void recursive(TreeNode root, LinkedList<Integer> list, List<List<Integer>> lists, int sum, int target) {
        if (root == null) return;
        sum += root.data;
        list.add(root.data);
        if (root.left == null && root.right == null) {
            if (sum == target)
                lists.add(new LinkedList<Integer>(list));
            return;
        }
        recursive(root.left, list, lists, sum, target);
        recursive(root.right, list, lists, sum, target);
        list.removeLast();
    }


    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList();
        Queue<TreeNode> queue = new LinkedList();
        if (root == null) return list;
        queue.offer(root);
        while (!queue.isEmpty()) {
            int n = queue.size();
            TreeNode temp = null;
            for (int i = 0; i < n; i++) {
                temp = queue.poll();
                if (temp.left != null) {
                    queue.offer(temp.left);
                }
                if (temp.right != null) {
                    queue.offer(temp.right);
                }
            }
            list.add(temp.data);
        }
        return list;
    }

    int preindex = 0;

    public TreeNode mergeTrees(int[] preorder, int[] inorder) {
        return createTree(preorder, inorder, 0, preorder.length - 1);
    }

    public TreeNode createTree(int[] preorder, int[] inorder, int left, int right) {
        int[] inroders = preorder.clone();
        Arrays.sort(preorder);
        for (int a : inroders) {
            System.out.println(a);
        }
        StringBuilder sb = new StringBuilder();

        if (left > right) return null;
        int inOrder = 0;
        TreeNode root = new TreeNode(preorder[preindex++]);
        for (int i = left; i <= right; i++) {
            if (inorder[i] == root.data) {
                inOrder = i;
                break;
            }
        }
        root.left = createTree(preorder, inorder, left, inOrder - 1);
        root.right = createTree(preorder, inorder, inOrder + 1, right);
        return root;
    }

    public TreeNode createBST(String[] data) {
        return constructBST(data, 0, data.length - 1);
    }

    public TreeNode constructBST(String[] data, int left, int right) {
        if (left > right) return null;
        TreeNode root = new TreeNode(Integer.parseInt(data[left]));
        int i;
        for (i = left; i <= right; i++) {
            if (Integer.parseInt(data[i]) > root.data) break;
        }
        root.left = constructBST(data, left + 1, i - 1);
        root.right = constructBST(data, i, right);
        return root;
    }
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        ArrayList<Object> list1 = new ArrayList<>();
        ArrayList<Object> list2 = new ArrayList<>();
        dfsSubtree(root,list1);
        dfsSubtree(subRoot,list2);
        if(list1.contains(list2)) return true;
        else return false;
    }

    public void dfsSubtree(TreeNode root,ArrayList<Object> list){
        if(root==null){
            list.add(null);
            return;
        }
        list.add(root.data);
        dfsSubtree(root.left,list);
        dfsSubtree(root.right,list);
    }

    public static void main(String[] args) {
        BinaryTreePractice binaryTreePractice = new BinaryTreePractice();
       /* binaryTreePractice.root = new TreeNode(10);
        binaryTreePractice.root.left = new TreeNode(20);
        binaryTreePractice.root.right = new TreeNode(30);*/
        //  binaryTreePractice.recursivePreOrderTraversal(binaryTreePractice.root);
        // binaryTreePractice.pathSum(binaryTreePractice.root, 30);
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        //binaryTreePractice.mergeTrees(preorder,inorder);
        String[] data = {"2", "1", "3"};
        //binaryTreePractice.isSubtree(root,subRoot);
    }
}
