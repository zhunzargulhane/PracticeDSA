package datastructuresandalgorithms.binaryTree;

import java.util.*;

public class BinaryTree {
    private TreeNode root;

    private static class TreeNode {
        private TreeNode left;
        private TreeNode right;
        private final int data;

        TreeNode(int data) {
            this.data = data;
        }
    }

    public void preOrder(TreeNode root) {
        if (root == null)
            return;
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public void createBinaryTree() {
        TreeNode first = new TreeNode(3);
        TreeNode second = new TreeNode(0);
        TreeNode third = new TreeNode(0);
        /*TreeNode fourth = new TreeNode(1);
        TreeNode fifth = new TreeNode(3);*/
       /* TreeNode fifth = new TreeNode(50);
        TreeNode sixth = new TreeNode(60);
        TreeNode seventh = new TreeNode(70);*/
        root = first;
        first.left = second;
        first.right = third;
      /*  second.left = fourth;
        second.right = fifth;*/
      /*  third.left = sixth;
        third.right = seventh;
    }*/
    }

    public void iterativeOrderTraversal(TreeNode root) {
        //externally using stack data struture.
        Stack<TreeNode> stack = new Stack();
        if (root == null)
            return;
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

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root==null)
            return new TreeNode(val);
        if(val>root.data)
            root.right=insertIntoBST(root.right,val);
        else
            root.left = insertIntoBST(root.left,val);
        return root;
    }


    static int move=0;
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.createBinaryTree();
        binaryTree.distributeCoins(binaryTree.root);
       // System.out.println(move);
        //binaryTree.insertIntoBST(binaryTree.root,5);
        //System.out.println(binaryTree.binaryTreePathsTarget(binaryTree.root, 4));

    }



    public void distributeCoins(TreeNode root) {
       //// dfs(root);

      //  return move;
    }

    public int dfs(TreeNode root){
        if(root==null) return 0;
        int left = dfs(root.left);
        int right = dfs(root.right);
        move=move+Math.abs(left+right+(root.data-1));
        return left+right+(root.data-1);
    }


    public void recursivePreOrder(TreeNode root) {
        if (root == null)
            return;
        System.out.println(root.data);
        recursivePreOrder(root.left);
        recursivePreOrder(root.right);
    }

    public void recursiveInOrderTraversal(TreeNode root) {
        if (root == null)
            return;
        recursiveInOrderTraversal(root.left);
        System.out.print(root.data + " ");
        recursiveInOrderTraversal(root.right);
    }

    public void iterativeInOrderTraversal(TreeNode root) {
        if (root == null)
            return;
        Stack<TreeNode> stack = new Stack();
        TreeNode temp = root;
        while (!stack.isEmpty() || temp != null) {
            if (temp != null) {
                stack.push(temp);
                temp = temp.left;
            } else {
                temp = stack.pop();
                System.out.print(temp.data + " ");
                temp = temp.right;
            }
        }
    }

    static Stack<TreeNode> stackUnique = new Stack();
    ArrayList<String> list = new ArrayList();
    Stack<TreeNode> stack2 = new Stack();
    Queue<TreeNode> queue = new LinkedList();

    public List<String> binaryTreePathsRecursion(TreeNode root) {
        if (root == null)
            return list;
        else {
            stackUnique.push(root);
            queue.offer(root);
        }
        binaryTreePathsRecursion(root.left);
        binaryTreePathsRecursion(root.right);
        if (root.left == null && root.right == null) {
            String s = "";
            while (!queue.isEmpty())
                s = s + queue.peek().data + "->";
            list.add(s.substring(0, s.length() - 2));
            /*while (!stackUnique.isEmpty()) {
                stack2.push(stackUnique.pop());
            }
            while (!stack2.isEmpty()) {
                s = s + stack2.peek().data + "->";
                stackUnique.push(stack2.pop());
                System.out.print(stackUnique.peek().data + " ");
            }*/

            stackUnique.pop();

        } else {
            stackUnique.pop();
        }
        return list;
    }


    List<List<Integer>> list2 = new ArrayList<List<Integer>>();
    ArrayList<Integer> list1 = new ArrayList();

    public List<List<Integer>> binaryTreePathsTarget(TreeNode root, int targetSum) {
        if (root == null)
            return list2;
        else {
            stackUnique.push(root);
        }
        binaryTreePathsTarget(root.left, targetSum);
        binaryTreePathsTarget(root.right, targetSum);
        if (root.left == null && root.right == null) {
            while (!stackUnique.isEmpty()) {
                stack2.push(stackUnique.pop());
            }
            while (!stack2.isEmpty()) {
                list1.add(stack2.peek().data);
                stackUnique.push(stack2.pop());
            }
            int sum = 0;
            for (int i = 0; i < list1.size(); i++)
                sum += list1.get(i);
            if (targetSum == sum)
                list2.add(list1);
            list1 = new ArrayList<Integer>();
            stackUnique.pop();
        } else {
            stackUnique.pop();
        }
        return list2;
    }


    public List<String> binaryTreePaths(TreeNode root) {
        ArrayList<String> list = new ArrayList();
        if (root == null)
            return list;
        Stack<TreeNode> stack = new Stack();
        Stack<TreeNode> stack2 = new Stack();
        TreeNode current = root;
        if (current.left == null && current.right == null) {
            list.add(String.valueOf(current.data));
            return list;
        }
        while (!stack.isEmpty() || current != null) {
            if (current != null) {
                stack.push(current);
                current = current.left;
            } else {
                TreeNode temp = stack.peek().right;
                if (stack.peek().data == root.data && root.right == null)
                    return list;
                else if (temp == null && stack.peek().right != null) {
                    String s = "";
                    while (!stack.isEmpty()) {
                        stack2.push(stack.pop());
                    }
                    while (!stack2.isEmpty()) {
                        s = s + stack2.peek().data + "->";
                        stack.push(stack2.pop());
                        System.out.print(stack.peek().data + " ");
                    }
                    list.add(s.substring(0, s.length() - 2));
                    temp = stack.pop();
                    while (!stack.isEmpty() && temp == stack.peek().right) {
                        temp = stack.pop();
                    }
                } else {
                    current = temp;
                }
            }
        }
        return list;
    }

    public void inorderTraversalWithoutRecursion(TreeNode root) {
        if (root == null)
            return;
        Stack<TreeNode> stack = new Stack();
        TreeNode temp = root;
        while (!stack.isEmpty() || temp != null) {
            if (temp != null) {
                stack.push(temp);
                temp = temp.left;
            } else {
                temp = stack.pop();
                System.out.print(temp.data + " ");
                temp = temp.right;
            }
        }
    }












    public void postOrderTraversal(TreeNode root) {
        if (root == null)
            return;
        Stack<TreeNode> stack = new Stack();
        TreeNode temp = root;
        while (!stack.isEmpty() || temp != null) {
            if (temp != null) {
                stack.push(temp);
                temp = temp.right;
            } else {
                temp = stack.pop();
                System.out.print(temp.data + " ");
                temp = temp.left;
            }
        }
    }

}
