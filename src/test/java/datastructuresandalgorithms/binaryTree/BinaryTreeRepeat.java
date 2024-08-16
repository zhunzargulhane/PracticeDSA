package datastructuresandalgorithms.binaryTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class BinaryTreeRepeat {
    List<Integer> list = new ArrayList<Integer>();
    private TreeNode root;

    private static class TreeNode {
        int data;
        private TreeNode left;
        private TreeNode right;

        TreeNode(int data) {
            this.data = data;
        }
    }

    public void createBinaryTree() {
        TreeNode first = new TreeNode(1);
        TreeNode second = new TreeNode(2);
        TreeNode third = new TreeNode(3);
        TreeNode fourth = new TreeNode(4);
        root = second;
        second.left = first;
        second.right = third;
        first.right = fourth;
    }

    public void recursivePreOrderTraversal(TreeNode root) {
        if (root == null)
            return;
        System.out.print(root.data + " ");
        recursivePreOrderTraversal(root.left);
        recursivePreOrderTraversal(root.right);
    }

    public void recursiveInOrderTraversal(TreeNode root) {
        if (root == null)
            return;
        recursivePreOrderTraversal(root.left);
        System.out.print(root.data + " ");
        recursivePreOrderTraversal(root.right);
    }

    public void recursivePostOrderTraversal(TreeNode root) {
        if (root == null)
            return;
        recursivePostOrderTraversal(root.left);
        recursivePostOrderTraversal(root.right);
        System.out.print(root.data + " ");
    }

    public static void main(String[] args) {
        BinaryTreeRepeat binaryTreeRepeat = new BinaryTreeRepeat();
        binaryTreeRepeat.createBinaryTree();
        binaryTreeRepeat.countTreeNodesRecursive(binaryTreeRepeat.root);
        // binaryTreeRepeat.recursivePostOrderTraversal(binaryTreeRepeat.root);
      /*  System.out.println(countTreeNodes(binaryTreeRepeat.root));
        System.out.println(binaryTreeRepeat.iterativePostOrder2(binaryTreeRepeat.root));*/
       /* binaryTreeRepeat.recursivePreOrderTraversal(binaryTreeRepeat.root);
        System.out.println();
        binaryTreeRepeat.recursiveInOrderTraversal(binaryTreeRepeat.root);
        System.out.println();*/
        //binaryTreeRepeat.recursivePostOrderTraversal(binaryTreeRepeat.root);
        // System.out.println();
        //  binaryTreeRepeat.iterativePostOrder(binaryTreeRepeat.root);

    }


    public List<Integer> iterativePostOrder2(TreeNode root) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        if (root == null)
            return arrayList;
        Stack<TreeNode> stack = new Stack();
        TreeNode current = root;
        while (!stack.isEmpty() || current != null) {
            if (current != null) {
                stack.push(current);
                current = current.left;
            } else {
                TreeNode temp = stack.peek().right;
                if (temp == null) {
                    temp = stack.pop();
                    arrayList.add(temp.data);
                    while (!stack.isEmpty() && temp == stack.peek().right) {
                        temp = stack.pop();
                        arrayList.add(temp.data);
                    }
                } else {
                    current = temp;
                }
            }
        }
        return arrayList;
    }


    public void iterativePreOrder(TreeNode root) {
        if (root == null)
            return;
        Stack<TreeNode> stack = new Stack();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode temp = stack.pop();
            System.out.println(temp.data);
            if (temp.right != null)
                stack.push(temp.right);
            if (temp.left != null)
                stack.push(temp.left);
        }
    }

    int count = 1;

    public int countTreeNodesRecursive(TreeNode root) {
        if (root == null)
            return 0;
        System.out.println(root.data + " " + count++);
        countTreeNodesRecursive(root.left);
        countTreeNodesRecursive(root.right);
        return count;
    }


    public static int countTreeNodes(TreeNode root) {
        int count = 0;
        if (root == null)
            return 0;
        Stack<TreeNode> stack = new Stack();
        stack.push(root);
        count++;
        while (!stack.isEmpty()) {
            TreeNode temp = stack.pop();
            if (temp.left != null) {
                stack.push(temp.left);
                count++;
            }
            if (temp.right != null) {
                stack.push(temp.right);
                count++;
            }
        }
        return count;
    }

    public List<Integer> iterativePostOrder(TreeNode root) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        if (root == null)
            return arrayList;

        Stack<TreeNode> stack = new Stack();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode temp = stack.pop();
            arrayList.add(temp.data);
            if (temp.left != null)
                stack.push(temp.left);
            if (temp.right != null)
                stack.push(temp.right);
        }
        Collections.reverse(arrayList);
        return arrayList;
        //   System.out.println(arrayList);
    }



    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null)
            return list;
        preorderTraversal2(root, list);
        return list;
    }

    public void preorderTraversal2(TreeNode root, List<Integer> list) {
        if (root == null)
            return;
        list.add(root.data);
        System.out.println(root.data);
        preorderTraversal(root.left);
        preorderTraversal(root.right);
    }

}
