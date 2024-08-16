package datastructuresandalgorithms.practiceproblems;

import java.util.Currency;
import java.util.NoSuchElementException;

public class CircularLinkedList {

    private ListNode last;

    private static class ListNode {
        private int data;
        private ListNode next;

        ListNode(int data) {
            this.data = data;
        }
    }

    public void addNodeAtBeginning(int value) {
        ListNode newNode = new ListNode(value);
        if (last == null)
            last = newNode;
        else
            newNode.next = last.next;
        last.next = newNode;
    }

    public void insertNodeAtEndCircularLL(int value) {
        ListNode newNode = new ListNode(value);
        if (last == null)
            last = newNode;
        else {
            newNode.next = last.next;
        }
        last.next = newNode;
        last = newNode;
    }

    public void deleteFirstNode() {
        if (last == null)
            throw new NoSuchElementException();
        if (last == last.next)
            last = null;
        else
            last.next = last.next.next;
    }

    public void deleteLastNodeCLL() {
        if (last == null)
            throw new NoSuchElementException();
        if (last == last.next) {
            last = null;
            return;
        }
        ListNode first = last.next;
        while (first.next != last) {
            first = first.next;
        }
        first.next = last.next;
        last = first;
    }

    public static void main(String[] args) {
        CircularLinkedList circularLinkedList = new CircularLinkedList();
       /* circularLinkedList.addNodeAtBeginning(10);
        circularLinkedList.addNodeAtBeginning(20);
        circularLinkedList.addNodeAtBeginning(30);*/
        circularLinkedList.insertNodeAtEndCircularLL(10);
        circularLinkedList.insertNodeAtEndCircularLL(20);
        circularLinkedList.insertNodeAtEndCircularLL(30);
        System.out.println(circularLinkedList.last.data);
        System.out.println(circularLinkedList.last.next.data);
        circularLinkedList.display();
        circularLinkedList.deleteLastNodeCLL();
        circularLinkedList.deleteLastNodeCLL();
        circularLinkedList.deleteLastNodeCLL();
        circularLinkedList.deleteLastNodeCLL();
        circularLinkedList.display();
    }

    public void display() {
        int count = 1;
        if (last == null)
            return;
        ListNode temp = last.next;
        while (temp != last) {
            count++;
            System.out.print(temp.data + " --> ");
            temp = temp.next;
        }
        System.out.print(temp.data + " ");
        System.out.println("The count is " + count);
        System.out.println();
    }
}
