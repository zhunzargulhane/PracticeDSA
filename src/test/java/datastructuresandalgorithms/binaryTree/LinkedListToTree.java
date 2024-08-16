package datastructuresandalgorithms.binaryTree;

class ListNode {

    ListNode head;
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public void createLinkedList() {
        ListNode first = new ListNode(-10);
        ListNode second = new ListNode(-3);
        ListNode third = new ListNode(0);
        ListNode fourth = new ListNode(5);
        ListNode fifth = new ListNode(9);
        head = first;
        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;

    }

}

public class LinkedListToTree {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    public TreeNode sortedListToBST(ListNode head) {
        if (head == null)
            return null;
        if (head.next == null){
            TreeNode root = new TreeNode(head.val);
            return root;
        }
        return traversal(head);
    }

    public TreeNode traversal(ListNode head) {
        if (head == null)
            return null;
        if (head.next == null){
            TreeNode root = new TreeNode(head.val);
            return root;
        }
        ListNode slowPtr = head;
        ListNode fastPtr = head;
        ListNode prev = slowPtr;
        while (fastPtr != null && fastPtr.next != null) {
            prev = slowPtr;
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }
        prev.next = null;
        TreeNode root = new TreeNode(slowPtr.val);
        root.left = traversal(head);
        root.right = traversal(slowPtr.next);
        return root;
    }

    public static void main(String[] args) {
        ListNode list = new ListNode();
        list.createLinkedList();
        LinkedListToTree treeNode = new LinkedListToTree();
        treeNode.sortedListToBST(list.head);
    }
}
