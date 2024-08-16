package datastructuresandalgorithms.practiceproblems;

import java.util.NoSuchElementException;

public class DoublyLinkedList {
    private ListNode head;
    private ListNode tail;

    private static class ListNode {
        private int data;
        private ListNode previous;
        private ListNode next;

        ListNode(int data) {
            this.data = data;
        }
    }

    public ListNode addNodeAtBeginning(int value) {
        ListNode newNode = new ListNode(value);
        if (head == null)
            tail = newNode;
        else {
            head.previous = newNode;
            newNode.next = head;
        }
        head = newNode;
        return head;
    }

    public ListNode addNodeAtEnd(int value) {
        ListNode newNode = new ListNode(value);
        if (tail == null)
            head = newNode;
        else {
            newNode.previous = tail;
            tail.next = newNode;
        }
        tail = newNode;
        return head;
    }

    public ListNode deleteFirstNodeDLL() {
        if (head == null)
            throw new NoSuchElementException();
        ListNode temp = head;
        if (head == tail)
            tail = null;
        else {
            temp.next.previous = null;
        }
        head = temp.next;
        return temp;
    }

    public ListNode deleteLastNodeDLL() {
        if (tail == null)
            throw new NoSuchElementException();
        ListNode temp = tail;
        if (head == tail) {
            head = null;
        } else {
            temp.previous.next = null;
        }
        tail = temp.previous;
        return temp;
    }


    public static void main(String[] args) {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
       /* doublyLinkedList.addNodeAtBeginning(10);
        doublyLinkedList.addNodeAtBeginning(20);
        doublyLinkedList.addNodeAtBeginning(30);*/
        doublyLinkedList.addNodeAtEnd(10);
        doublyLinkedList.addNodeAtEnd(20);
        doublyLinkedList.addNodeAtEnd(30);
        doublyLinkedList.displayFromHead();
        doublyLinkedList.displayFromTail();


        System.out.println(doublyLinkedList.deleteLastNodeDLL().data);
        System.out.println(doublyLinkedList.deleteLastNodeDLL().data);
        System.out.println(doublyLinkedList.deleteLastNodeDLL().data);

        doublyLinkedList.displayFromHead();
        doublyLinkedList.displayFromTail();
    }


    public void displayFromHead() {
        if (head == null)
            return;
        ListNode current = head;
        int count = 0;
        while (current != null) {
            count++;
            System.out.print(current.data + " -->");
            current = current.next;
        }
        System.out.print(" null");
        System.out.print(" The count of DLL is " + count);
        System.out.println();
    }

    public void displayFromTail() {
        if (tail == null)
            return;
        ListNode current = tail;
        int count = 0;
        while (current != null) {
            count++;
            System.out.print(current.data + " -->");
            current = current.previous;
        }
        System.out.print(" null");
        System.out.print(" The count of DLL is " + count);
        System.out.println();
    }
}
