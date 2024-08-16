package datastructuresandalgorithms.binaryTree;

import groovyjarjarantlr4.runtime.tree.Tree;
import lombok.val;
import sun.awt.image.ImageWatched;

import java.util.*;

public class BinaryTreeR {

    private TreeNode root;
    private TreeNode subRoot;

    private static class TreeNode {
        private int data;
        private TreeNode left;
        private TreeNode right;

        TreeNode(int data) {
            this.data = data;
        }
    }

    public void createBinaryTree() {
        TreeNode first = new TreeNode(1);
        TreeNode second = new TreeNode(0);
        TreeNode third = new TreeNode(1);
        TreeNode fourth = new TreeNode(0);
        TreeNode fifth = new TreeNode(1);
        TreeNode sixth = new TreeNode(0);
        TreeNode seventh = new TreeNode(1);
        root = first;
        first.left = second;
        first.right = third;
        second.left=fourth;
        second.right=fifth;
        third.left=sixth;
        third.right=seventh;
    }

    public void createSubTree() {
        TreeNode first = new TreeNode(4);
        TreeNode second = new TreeNode(1);
        TreeNode third = new TreeNode(2);
        subRoot = first;
        first.left = second;
        first.right = third;
    }

    public void preOrderTraversal(TreeNode root) {
        if (root == null)
            return;
        System.out.print(root.data + " ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    public void iterativePreOrderTraversal(TreeNode root) {
        if (root == null)
            return;
        Stack<TreeNode> stack = new Stack();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode temp = stack.pop();
            System.out.print(temp.data + " ");
            if (temp.right != null)
                stack.push(temp.right);
            if (temp.left != null)
                stack.push(temp.left);
        }
    }

    public void inOrderRecursiveTraversal(TreeNode root) {
        if (root == null)
            return;
        inOrderRecursiveTraversal(root.left);
        System.out.print(root.data + " ");
        inOrderRecursiveTraversal(root.right);
    }

    public void inOrderIterativeTraversal(TreeNode root) {
        if (root == null)
            return;
        Stack<TreeNode> stack = new Stack<TreeNode>();
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

    public void postorderRecursiveTraversal(TreeNode root) {
        if (root == null)
            return;
        postorderRecursiveTraversal(root.left);
        postorderRecursiveTraversal(root.right);
        System.out.print(root.data + " ");
    }

    public List<Integer> postOrderIterativeTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        if (root == null)
            return list;
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
                    list.add(temp.data);
                    System.out.print(temp.data + " ");
                    while (!stack.isEmpty() && temp == stack.peek().right) {
                        temp = stack.pop();
                        list.add(temp.data);
                        System.out.print(temp.data + " ");
                    }
                } else {
                    current = temp;
                }
            }
        }
        return list;
    }

    int count = 0;

    public int countNodes(TreeNode root) {
        if (root == null)
            return 0;
        count++;
        countNodes(root.left);
        countNodes(root.right);
        return count;
    }

    ArrayList<String> list = new ArrayList<String>();
    Stack<TreeNode> stack1 = new Stack<TreeNode>();
    Stack<TreeNode> stack2 = new Stack<TreeNode>();

    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null)
            return list;
        else
            stack1.push(root);
        binaryTreePaths(root.left);
        binaryTreePaths(root.right);
        if (root.left == null && root.right == null) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
            String s = "";
            while (!stack2.isEmpty()) {
                TreeNode temp = stack2.peek();
                s = s + temp.data + "->";
                stack1.push(stack2.pop());
            }
            list.add(s.substring(0, s.length() - 2));
            stack1.pop();
        } else {
            stack1.pop();
        }
        return list;
    }


    int totalSum = 0;

    public int dfsPreOrder(TreeNode root, int val) {
        if (root == null)
            return 0;
        val = val * 10 + root.data;
        if (root.left == null && root.right == null) {
            return totalSum = totalSum + val;
        }
        dfsPreOrder(root.left, val);
        dfsPreOrder(root.right, val);
        return totalSum;
    }

    public int sumNumbers(TreeNode root) {
        int val = 0;
        return dfsPreOrder(root, val);
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0)
            return null;
        return insertNodes(nums, 0, nums.length - 1);

    }

    public TreeNode insertNodes(int[] nums, int left, int right) {
        if (left > right)
            return null;
        int mid = (left + right) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = insertNodes(nums, left, mid - 1);
        root.right = insertNodes(nums, mid + 1, right);
        return root;
    }

    public TreeNode bstFromPreorder(int[] preorder) {
        ArrayList list = new ArrayList();
        for (int num : preorder)
            list.add(num);
        Collections.sort(list);
        for (int i = 0; i < preorder.length; i++) {
            preorder[i] = (Integer) list.get(i);
        }
        if (preorder.length == 0)
            return null;
        else return bst(preorder, 0, preorder.length - 1);
    }

    public TreeNode bst(int[] preorder, int left, int right) {
        if (left > right)
            return null;
        int mid = (left + right) / 2;
        TreeNode root = new TreeNode(preorder[mid]);
        root.left = bst(preorder, left, mid - 1);
        root.right = bst(preorder, mid + 1, right);
        return root;
    }

    ArrayList<String> listString = new ArrayList();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // TreeNode root= new TreeNode(preorder[0]);
        //  return createTree(root,preorder,inorder);
        return createTree(preorder, inorder, 0, preorder.length - 1);
    }

    int preIndex = 0;

    public TreeNode createTree(int[] preorder, int[] inorder, int left, int right) {
        if (left > right)
            return null;
        TreeNode root = new TreeNode(preorder[preIndex]);
        preIndex++;
        int inIndex = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == root.data) {
                inIndex = i;
                break;
            }
        }
        root.left = createTree(preorder, inorder, left, inIndex - 1);
        root.right = createTree(preorder, inorder, inIndex + 1, right);
        return root;
    }


    public void dfsPreOrderBinaryPaths(TreeNode root, StringBuilder val) {
        if (root == null)
            return;
        val = val.append(root.data).append("->");
        if (root.left == null && root.right == null) {
            listString.add(val.substring(0, val.length() - 2));
            return;
        }
        int length = val.length();
        dfsPreOrderBinaryPaths(root.left, val);
        val.setLength(length);
        dfsPreOrderBinaryPaths(root.right, val);
    }


    public List<String> binaryTreePathss(TreeNode root) {
        dfsPreOrderBinaryPaths(root, new StringBuilder());
        return listString;
    }

    ArrayList<Integer> countList = new ArrayList();

    public void dfsPreOrderDepth(TreeNode root, int count) {
        if (root == null)
            return;
        count++;
        if (root.left == null && root.right == null) {
            countList.add(count);
            return;
        }
        dfsPreOrderDepth(root.left, count);
        dfsPreOrderDepth(root.right, count);
    }


    public int minDepth(TreeNode root) {
        dfsPreOrderDepth(root, 0);
        if (!countList.isEmpty())
            return Collections.min(countList);
        else return 0;
    }

    ArrayList<TreeNode> treeList = new ArrayList();

    public TreeNode invertTree(TreeNode root) {
        if (root == null)
            return null;
        if (root.left != null | root.right != null) {
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
        }
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

    public int findMax(TreeNode root) {
        if (root == null)
            return Integer.MIN_VALUE;
        int result = root.data;
        int left = findMax(root.left);
        int right = findMax(root.right);
        if (left > result)
            result = left;
        if (right > result)
            result = right;
        return result;
    }

    boolean result = true;

    public boolean isBalanced(TreeNode root) {
        balancedTree(root);
        return result;
    }

    public int balancedTree(TreeNode root) {
        if (root == null)
            return 0;
        int left = balancedTree(root.left);
        int right = balancedTree(root.right);
        if (Math.abs(left - right) > 1)
            result = false;
        return 1 + Math.max(left, right);
    }

    int totalTarget = 0;

    boolean resultFlag = false;

    public boolean hasPathSum(TreeNode root, int targetSum) {
       /* if (root == null)
            return true;
        int sum = 0;
        sum = sum + root.data;
        if (root.left == null && root.right == null) {
            totalTarget = totalTarget + sum;
            if (totalTarget == targetSum)
                resultFlag = true;
            totalTarget=0;
        }
        hasPathSum(root.left, targetSum);
        hasPathSum(root.left, targetSum);*/
        pathSumHas(root, targetSum, 0);
        return resultFlag;
    }

    public void pathSumHas(TreeNode root, int targetSum, int sum) {
        if (root == null)
            return;
        sum = sum + root.data;
        if (root.left == null && root.right == null) {
            if (sum == targetSum)
                resultFlag = true;
            return;
        }
        pathSumHas(root.left, targetSum, sum);
        pathSumHas(root.right, targetSum, sum);
    }


    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new LinkedList();
        Queue<TreeNode> queue = new LinkedList();
        if (root == null)
            return list;
        queue.offer(root);
        while (!queue.isEmpty()) {
            int n = queue.size();
            TreeNode temp = null;
            for (int i = 0; i < n; i++) {
                temp = queue.poll();
                if (temp.left != null)
                    queue.offer(temp.left);
                if (temp.right != null)
                    queue.offer(temp.right);
            }
            list.add(temp.data);
        }
        return list;
    }

    TreeNode dummy = new TreeNode(0);
    //TreeNode temp = dummy;
    List<TreeNode> listt = new ArrayList();

    public void flatten(TreeNode root) {
        dfs(root);
        TreeNode temp = root;
        for (int i = 1; i < listt.size(); i++) {
            temp.right = listt.get(i);
            temp.left = null;
            temp = temp.right;
        }
    }

    public void dfs(TreeNode root) {
        if (root == null)
            return;
        listt.add(root);
        dfs(root.left);
        dfs(root.right);
    }

    int results = 0;

    public int diameter(TreeNode root) {
        dfsDiameter(root);
        return results;
    }

    public int dfsDiameter(TreeNode root) {
        if (root == null)
            return 0;
        int left = dfsDiameter(root.left);
        int right = dfsDiameter(root.right);
        results = Math.max(results, left + right);
        return 1 + Math.max(left, right);
    }


    int resultalpha = 0;

    //  ArrayList<Integer> list= new ArrayList();
    public int sumOfLeftLeaves(TreeNode root) {
        levelOrder(root);
        return resultalpha;
    }

    public TreeNode levelOrder(TreeNode root) {
        if (root == null)
            return null;
        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                TreeNode temp = queue.poll();
                if (temp.left != null) {
                    queue.offer(temp.left);
                    if (temp.left.left == null && temp.left.right == null) {
                        resultalpha = resultalpha + temp.left.data;
                    }
                }
                if (temp.right != null) {
                    queue.offer(temp.right);
                }
            }
        }
        return root;
    }

    int getTotalSum;

    public int sumOfLeftLeaves11(TreeNode root) {
        if (root == null)
            return 0;
        if (root.left != null && root.left.left == null && root.left.right == null)
            getTotalSum = getTotalSum + root.left.data;
        sumOfLeftLeaves11(root.left);
        sumOfLeftLeaves11(root.right);
        return getTotalSum;
    }

    public TreeNode insertTreeNode(TreeNode root, int value) {
        if (root == null) {
            root = new TreeNode(value);
            return root;
        }
        if (value < root.data) {
            root.left = insertTreeNode(root.left, value);
        } else {
            root.right = insertTreeNode(root.right, value);
        }
        return root;
    }

    int key1 = 0;

    public int searchKeyInBST(TreeNode root, int key) {
        if (root == null)
            return 0;
        if (root.data == key)
            return key;
        if (key < root.data) {
            key1 = searchKeyInBST(root.left, key);
        } else {
            key1 = searchKeyInBST(root.right, key);
        }
        return key1;
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null)
            return null;
        TreeNode head = root;
        if (root.data == key) {
            if (root.left == null && root.right == null)
                return null;
            if (root.left == null && root.right != null)
                return root.right;
            if (root.left != null && root.right == null)
                return root.left;
            if (root.left != null && root.right != null) {
                TreeNode temp1 = root.left;
                TreeNode temp2 = root.right;
                TreeNode current = temp2;
                while (current.left != null)
                    current = current.left;
                current.left = temp1;
                return temp2;
            }
        }
        safeDelete(root, key);
        return head;
    }

    public TreeNode safeDelete(TreeNode root, int key) {
        if (root == null)
            return null;
        if (root.data == key) {
            if (root.left == null && root.right == null) {
                if (root.data < prev.data)
                    return prev.left = null;
                else
                    return prev.right = null;
            }
            if (root.left == null && root.right != null) {
                if (root.data < prev.data)
                    return prev.left = root.right;
                else
                    return prev.right = root.right;
            }
            if (root.left != null && root.right == null) {
                if (root.data < prev.data)
                    return prev.left = root.left;
                else
                    return prev.right = root.left;
            }
            if (root.left != null && root.right != null) {
                TreeNode temp1 = root.left;
                TreeNode temp2 = root.right;
                TreeNode current = temp2;
                while (current.left != null)
                    current = current.left;
                current.left = temp1;
                if (root.data < prev.data)
                    return prev.left = temp2;
                else
                    return prev.right = temp2;
            }
        } else
            prev = root;
        if (key < root.data)
            return safeDelete(root.left, key);
        else return safeDelete(root.right, key);
    }


    TreeNode secondParent = null;
    boolean globalFlag = true;

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null)
            return true;
        if (subRoot == null)
            return true;
        if (root.left == null && root.right == null)
            return root.data == subRoot.data;
        firstTraversal(root, subRoot);
        return startComparingTheNodes(secondParent, subRoot);
    }

    public TreeNode firstTraversal(TreeNode root, TreeNode subRoot) {
        if (root == null)
            return null;
        if (root.data == subRoot.data) {
            return secondParent = root;
        }
        firstTraversal(root.left, subRoot);
        firstTraversal(root.right, subRoot);
        return root;
    }

    public boolean isSubtree1(TreeNode root, TreeNode subRoot) {
        if (root == null || subRoot == null)
            return true;
        if (root.left == null && root.right == null)
            return root.data == subRoot.data;
        StringBuilder sb = new StringBuilder();
        traverseIn(root, sb);
        String sA = sb.toString();
        sb = new StringBuilder();
        traverseIn(subRoot, sb);
        String sB = sb.toString();
        if (sA.contains(sB))
            return true;
        else return false;
    }

    public TreeNode traverseIn(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("null");
            return null;
        }
        sb.append(root.data);
        traverseIn(root.left, sb);
        traverseIn(root.right, sb);
        return root;
    }

    public boolean startComparingTheNodes(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null)
            return true;
        if (root1 != null && root2 == null)
            return globalFlag = false;
        if (root1 == null && root2 != null)
            return globalFlag = false;
        if (root1.data != root2.data)
            return globalFlag = false;
        startComparingTheNodes(root1.left, root2.left);
        startComparingTheNodes(root1.right, root2.right);
        return globalFlag;
    }


    public TreeNode searchAndDeleteNode(TreeNode root, int key) {
        if (root == null || root.data == key)
            return root;
        if (key < root.data)
            return searchAndDeleteNode(root.left, key);
        else
            return searchAndDeleteNode(root.right, key);
    }

    public int findMin(TreeNode root) {
        if (root == null)
            return Integer.MAX_VALUE;
        int result = root.data;
        int left = findMin(root.left);
        int right = findMin(root.right);
        if (left < result)
            result = left;
        if (right < result)
            result = right;
        return result;
    }


    public List<List<Integer>> levelOrders(TreeNode root) {
        List<List<Integer>> arrayList = new ArrayList();
        List<Integer> al = new ArrayList<Integer>();
        if (root == null)
            return arrayList;
        Queue<TreeNode> queue1 = new LinkedList();
        Queue<TreeNode> queue2 = new LinkedList();
        queue1.offer(root);
        while (!queue1.isEmpty()) {
            TreeNode temp = queue1.poll();
            al.add(temp.data);
            if (temp.left != null)
                queue2.offer(temp.left);
            if (temp.right != null)
                queue2.offer(temp.right);
            if (queue1.isEmpty()) {
                arrayList.add(al);
                al = new ArrayList<Integer>();
                while (!queue2.isEmpty()) {
                    queue1.offer(queue2.poll());
                }
            }
        }
        Collections.reverse(arrayList);
        return arrayList;
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> lists = new LinkedList();
        LinkedList<Integer> list;
        if (root == null)
            return lists;
        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);
        int counter = 0;
        while (!queue.isEmpty()) {
            int n = queue.size();
            list = new LinkedList();
            for (int i = 0; i < n; i++) {
                TreeNode temp = queue.poll();
                list.add(temp.data);
                if (temp.left != null)
                    queue.offer(temp.left);
                if (temp.right != null)
                    queue.offer(temp.right);
            }
            if (counter == 0 || counter % 2 == 0)
                lists.add(list);
            else {
                Collections.reverse(list);
                lists.add(list);
            }
            counter++;
        }
        System.out.println("The height is  " + counter);
        return lists;
    }


    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> al = new ArrayList();
        List<Double> tempo = new ArrayList();
        if (root == null)
            return al;
        Queue<TreeNode> queue1 = new LinkedList();
        Queue<TreeNode> queue2 = new LinkedList();
        queue1.offer(root);
        double value = 0.0;
        while (!queue1.isEmpty()) {
            TreeNode temp = queue1.poll();
            Double d = new Double(temp.data);
            tempo.add(d);
            value = value + temp.data;
            if (temp.left != null)
                queue2.offer(temp.left);
            if (temp.right != null)
                queue2.offer(temp.right);
            if (queue1.isEmpty()) {
                al.add(value / tempo.size());
                tempo = new ArrayList();
                value = 0.0;
                while (!queue2.isEmpty()) {
                    queue1.offer(queue2.poll());
                }
            }
        }
        return al;
    }


    public List<Double> averageOfLevelsOptimize(TreeNode root) {
        List<Double> list = new ArrayList();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int n = queue.size();
            Double value = 0.0;
            for (int i = 0; i < n; i++) {
                TreeNode temp = queue.poll();
                value = value + temp.data;
                if (temp.left != null)
                    queue.offer(temp.left);
                if (temp.right != null)
                    queue.offer(temp.right);
            }
            list.add(value / n);
        }
        return list;
    }

    List<List<Integer>> listsFinal = new ArrayList();

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        if (root == null)
            return listsFinal;
        else
            stack1.push(root);
        pathSum(root.left, target);
        pathSum(root.right, target);
        if (root.left == null && root.right == null) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
            List<Integer> lists = new ArrayList();
            while (!stack2.isEmpty()) {
                TreeNode temp = stack2.peek();
                lists.add(temp.data);
                stack1.push(stack2.pop());
            }
            int sum = 0;
            for (int s : lists)
                sum = sum + s;
            if (sum == target)
                listsFinal.add(lists);
            stack1.pop();
        } else {
            stack1.pop();
        }
        return listsFinal;
    }

    List<Integer> list1 = new ArrayList();
    List<Integer> list2 = new ArrayList();

    public boolean isValidBST(TreeNode root) {
        dfsIsValid(root);
        Collections.sort(list1);
        return list1.equals(list2) && flag;
    }

    public void dfsIsValid(TreeNode root) {
        if (root == null)
            return;
        dfsIsValid(root.left);
        list1.add(root.data);
        list2.add(root.data);
        if (root.left != null) {
            if ((root.left.data < root.data) && !list1.contains(root.data)) {
            } else flag = false;
        }
        if (root.right != null) {
            if (root.right.data > root.data) {
            } else flag = false;
        }
        dfsIsValid(root.right);
    }

    public boolean isValidBST11(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidBST(TreeNode root, long min, long max) {
        if (root == null)
            return true;
        if (root.data <= min || root.data >= max)
            return false;
        boolean flag = isValidBST(root.left, min, root.data);
        if (flag) {
            flag = isValidBST(root.right, root.data, max);
            return flag;
        }
        return false;
    }


    public boolean isValidBST1(TreeNode root) {

        return false;
    }


    boolean flag = true;

    public void ddfs(TreeNode root) {
        if (root == null)
            return;
        if (root.left != null) {
            if (root.left.data < root.data) {
                ddfs(root.left);
                ddfs(root.right);
            } else {
                flag = false;
            }
        }
        if (root.right != null) {
            if (root.right.data > root.data) {
                ddfs(root.right);
                ddfs(root.left);
            } else {
                flag = false;
            }
        }
    }

    public TreeNode constructBSTFromPreOrder(int[] preorder) {
        if (preorder.length == 0)
            return null;
        return cBST(preorder, 0, preorder.length - 1);
    }

    public TreeNode cBST(int[] preorder, int left, int right) {
        if (left > right)
            return null;
        TreeNode root = new TreeNode(preorder[left]);
        int i;
        for (i = left; i <= right; i++) {
            if (root.data < preorder[i]) {
                break;
            }
        }
        root.left = cBST(preorder, left + 1, i - 1);
        root.right = cBST(preorder, i, right);
        return root;
    }

    public TreeNode constructBTFromPrePost(int[] preorder, int[] postorder) {
        if (preorder.length == 0)
            return null;
        return BTFromPrePost(preorder, postorder, 0, postorder.length - 1);
    }

    int index = 0;

    public TreeNode BTFromPrePost(int[] preorder, int[] postorder, int left, int right) {
        if (left > right)
            return null;
        TreeNode root = new TreeNode(preorder[index]);
        index++;
        int inIndex = 0;
        for (int i = 0; i < postorder.length - 1; i++) {
            if (index > preorder.length - 1)
                break;
            if (preorder[index] == postorder[i]) {
                inIndex = i;
                break;
            }
        }
        root.left = BTFromPrePost(preorder, postorder, left, inIndex - 1);
        root.right = BTFromPrePost(preorder, postorder, inIndex + 1, right);
        return root;
    }

    LinkedList<Integer> linkedList = new LinkedList<Integer>();

int min=0;
    public void recoverTree(TreeNode root) {
        dfsTraversal(root);
        Collections.sort(linkedList);
        dfsTraversalCompare(root, linkedList);
        System.out.println(root.data);
    }

    int i = 0;

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> list = new ArrayList();
        Queue<TreeNode> queue = new LinkedList();
        if(root==null)
            return list;
        queue.add(root);
        while(!queue.isEmpty()){
            int n=queue.size();
            PriorityQueue<Integer> pq = new PriorityQueue(n,Collections.reverseOrder());
            for(int i=0;i<n;i++){
                TreeNode temp = queue.poll();
                pq.add(temp.data);
                if(temp.left!=null)
                    queue.add(temp.left);
                if(temp.right!=null)
                    queue.add(temp.right);
            }
            list.add(pq.poll());
        }
        return list;
    }

    public TreeNode recursiveInorderTraversal(TreeNode root) {
        if (root == null)
            return null;
        recursiveInorderTraversal(root.left);
        System.out.print(root.data + " ");
        recursiveInorderTraversal(root.right);
        return root;
    }


    public TreeNode dfsTraversalCompare(TreeNode root, LinkedList list) {
        if (root == null)
            return null;
        dfsTraversalCompare(root.left, list);
        if ((Integer) list.get(i) != root.data) {
            root.data = (Integer) list.get(i);
        }
        i++;
        dfsTraversalCompare(root.right, list);
        return root;
    }

    public TreeNode dfsTraversal(TreeNode root) {
        if (root == null)
            return null;
        dfsTraversal(root.left);
        linkedList.add(root.data);
        dfsTraversal(root.right);
        return root;
    }

    TreeNode prev = null;
    int j = 0, first, middle, last;

    public void recoverPart2(TreeNode root) {
        recoverPart2Traversal(root);
        if (last != 0) {
            correctTheViolation(root, first, last);
        } else {
            correctTheViolation(root, first, middle);
        }
    }


    public TreeNode correctTheViolation(TreeNode root, int first, int last) {
        if (root == null)
            return null;
        correctTheViolation(root.left, first, last);
        if (root.data == first)
            root.data = last;
        else if (root.data == last)
            root.data = first;
        correctTheViolation(root.right, first, last);
        return root;
    }

    public TreeNode recoverPart2Traversal(TreeNode root) {
        if (root == null)
            return null;
        recoverPart2Traversal(root.left);
        if (prev != null && root.data < prev.data) {
            if (j == 0) {
                first = prev.data;
                middle = root.data;
                j++;
            } else {
                last = root.data;
            }
        }
        prev = root;
        recoverPart2Traversal(root.right);
        return root;
    }

    List<Integer> levellist1 = new LinkedList<Integer>();
    List<List<Integer>> levellist2 = new LinkedList<List<Integer>>();

    public List<List<Integer>> levelOrderTraversalRecursion(TreeNode root) {
        int height = heightOfTree(root);
        for (int i = 0; i < height; i++) {
            printLevel(root, i);
            levellist2.add(levellist1);
        }
        return levellist2;
    }


    public void printLevel(TreeNode root, int level) {
        if (root == null)
            return;
        if (level == 0)
            levellist1.add(root.data);
        if (level > 0) {
            printLevel(root.left, level - 1);
            printLevel(root.right, level - 1);
        }
    }

    public int heightOfTree(TreeNode root) {
        if (root == null)
            return 0;
        int left = heightOfTree(root.left);
        int right = heightOfTree(root.right);
        return 1 + Math.max(left, right);
    }


    public int findMaxOfBinaryTree(TreeNode root) {
        if (root == null)
            return -1;
        int result = root.data;
        int left = findMaxOfBinaryTree(root.left);
        int right = findMaxOfBinaryTree(root.right);
        if (left > result)
            result = left;
        if (right > result)
            result = right;

        return result;
    }

    ArrayList<Integer> rootToLeadList = new ArrayList();
    public int sumRootToLeaf(TreeNode root) {
        sumRoot(root, 0);
        int finalResult = 0;
        System.out.println(rootToLeadList);
        for (int i = 0; i < rootToLeadList.size(); i++) {
            finalResult+=BinaryToDecimal(rootToLeadList.get(i));
        }
        System.out.println("THe result is "+finalResult);
        return finalResult;
    }

    public int BinaryToDecimal(int num){
        int sum=0;
        int i=0;
        while(num>0){
            int digit=num%10;
            Double dd=new Double(Math.pow(2,i++));
            sum=sum+digit*dd.intValue();
            num=num/10;
        }
        return sum;
    }

    int k=0;
    public TreeNode sumRoot(TreeNode root, int sum) {
        if (root == null)
            return null;
        Double doube= new Double(Math.pow(2,k++));
        sum = sum + root.data*doube.intValue();
        sumRoot(root.left, sum);
        if (root.left == null && root.right == null){
           // rootToLeadList.add(Integer.parseInt(sum));
            return root;
        }
        sumRoot(root.right, sum);
        return root;
    }


    int sum=0;
    int finalSum=0;
    public int sumRootToLeaf1(TreeNode root) {
        dfss(root,0);
        return finalSum;
    }

    public TreeNode dfss(TreeNode root,int sum){
        if(root==null)
            return null;
        sum=sum*2+root.data;
        dfss(root.left,sum);
        if(root.left==null && root.right==null){
            finalSum+=sum;
            return root;
        }
        dfss(root.right,sum);
        return root;
    }



    public static void main(String[] args) {
        BinaryTreeR binaryTreeR = new BinaryTreeR();
        binaryTreeR.createBinaryTree();
        System.out.println(binaryTreeR.sumRootToLeaf1(binaryTreeR.root));
        //  binaryTreeR.createSubTree();
        //     System.out.println(binaryTreeR.findMaxOfBinaryTree(binaryTreeR.root));
      /*  TreeNode tree = binaryTreeR.deleteNode(binaryTreeR.root, 5);
        binaryTreeR.recursiveInorderTraversal(tree);*/
        //System.out.println(binaryTreeR.isSubtree(binaryTreeR.root,binaryTreeR.subRoot));
        //  System.out.println(binaryTreeR.isSubset(binaryTreeR.root, binaryTreeR.subRoot));
        /*binaryTreeR.root = binaryTreeR.insertTreeNode(binaryTreeR.root, 3);
        binaryTreeR.insertTreeNode(binaryTreeR.root, 2);
        binaryTreeR.insertTreeNode(binaryTreeR.root, 2);
        binaryTreeR.insertTreeNode(binaryTreeR.root, 2);
        if (binaryTreeR.search(binaryTreeR.root, 4) != null)
            System.out.println("key found");
        else System.out.println("key NOT found");
        TreeSet set = new TreeSet();
        LinkedList<Integer> linkedList = new LinkedList();
*/

        // int[] nums = {-10, -3, 0, 5, 9};
        //  int[] preorder = {1, 2, 4, 5, 3, 6, 7};
        // int[] postorder = {4, 5, 2, 6, 7, 3, 1};
        //binaryTreeR.constructBTFromPrePost(preorder, postorder);
        //   binaryTreeR.sumOfLeftLeaves(binaryTreeR.root);
        // binaryTreeR.sumOfLeftLeaves11(binaryTreeR.root);
        // binaryTreeR.recoverTree(binaryTreeR.root);
        //  binaryTreeR.recoverPart2(binaryTreeR.root);
        // binaryTreeR.sortedArrayToBST(nums);
        // binaryTreeR.bstFromPreorder(preorder);
        /*binaryTreeR.insertTreeNode(binaryTreeR.root, 6);
        binaryTreeR.insertTreeNode(binaryTreeR.root, 9);*/
      /*  if(binaryTreeR.search(binaryTreeR.root, 9)==null)
            System.out.println("No data found");
        else System.out.println(binaryTreeR.search(binaryTreeR.root, 9).data);
        List<Integer> list = new ArrayList();
*/
        // System.out.println(binaryTreeR.isValidBST(binaryTreeR.root));

        //binaryTreeR.createBinaryTree();
        /*binaryTreeR.preOrderTraversal(binaryTreeR.root);
        System.out.println();
        binaryTreeR.iterativePreOrderTraversal(binaryTreeR.root);
        System.out.println();
        binaryTreeR.inOrderRecursiveTraversal(binaryTreeR.root);
        System.out.println();
        binaryTreeR.inOrderIterativeTraversal(binaryTreeR.root);
        System.out.println();*/
        //  binaryTreeR.postorderRecursiveTraversal(binaryTreeR.root);
        //  binaryTreeR.postOrderIterativeTraversal(binaryTreeR.root);
        // System.out.println(binaryTreeR.countNodes(binaryTreeR.root));
        //System.out.println(binaryTreeR.sumNumbers(binaryTreeR.root));
        // System.out.println(binaryTreeR.binaryTreePathss(binaryTreeR.root));
        //System.out.println(binaryTreeR.minDepth(binaryTreeR.root));

        /*binaryTreeR.preOrderTraversal(binaryTreeR.root);
        System.out.println();
        binaryTreeR.invertTree(binaryTreeR.root);

        for(TreeNode temp:binaryTreeR.treeList)
            System.out.print(temp.data+" ");
*/
        // System.out.println();
        //System.out.println(binaryTreeR.levelOrder(binaryTreeR.root));
        // System.out.println(binaryTreeR.isBalanced(binaryTreeR.root));
        // System.out.println(binaryTreeR.hasPathSum(binaryTreeR.root, 30));
        //binaryTreeR.flatten(binaryTreeR.root);
        //  System.out.println(binaryTreeR.diameter(binaryTreeR.root));


    }

}
