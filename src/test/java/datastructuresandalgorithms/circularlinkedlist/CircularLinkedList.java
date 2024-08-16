package datastructuresandalgorithms.circularlinkedlist;

import org.checkerframework.checker.units.qual.C;

import java.util.NoSuchElementException;

public class CircularLinkedList {
    private ListNode last;

    private static class ListNode {
        int data;
        ListNode next;

        ListNode(int data) {
            this.data = data;
        }
    }


    public void createCircularLinkedList() {
        ListNode first = new ListNode(10);
        ListNode second = new ListNode(20);
        ListNode third = new ListNode(30);
        first.next = second;
        second.next = third;
        third.next = first;
        last = third;
    }

    public void display() {
        int count = 1;
        if (last == null)
            return;
        ListNode firstNode = last.next;
        while (firstNode != last) {
            count++;
            System.out.print(firstNode.data + " -->");
            firstNode = firstNode.next;
        }
        System.out.print(firstNode.data);
        System.out.println();
        System.out.println("The number of nodes in CLL are " + count);
    }

    public static void main(String[] args) {
        CircularLinkedList circularLinkedList = new CircularLinkedList();
       /* ListNode first = new ListNode(10);
        ListNode second = new ListNode(20);
        ListNode third = new ListNode(30);
        first.next = second;
        second.next = third;
        circularLinkedList.last = third;
        third.next = first;*/
        /*circularLinkedList.insertNodeCircularLL(10);
        circularLinkedList.insertNodeCircularLL(20);
        circularLinkedList.insertNodeCircularLL(30);*/
        // circularLinkedList.createCircularLinkedList();
      /*  circularLinkedList.insertNodeAtEndCircularLL(10);
        circularLinkedList.insertNodeAtEndCircularLL(20);
        circularLinkedList.insertNodeAtEndCircularLL(30);*/
        circularLinkedList.insertNodeAtBeginning(10);
        circularLinkedList.insertNodeAtBeginning(20);
        circularLinkedList.insertNodeAtBeginning(30);
        circularLinkedList.insertNodeAtEndCircularLL(40);
       /* circularLinkedList.display();
        circularLinkedList.removeLastNodeCLL();
        circularLinkedList.display();*/
        circularLinkedList.removeFirstNodeCLL();
        circularLinkedList.removeLastNodeCLL();
        circularLinkedList.removeLastNodeCLL();
        circularLinkedList.removeLastNodeCLL();
        circularLinkedList.display();
    }

    public void removeLastNodeCLL() {
        if (last == null)
            return;
        ListNode first = last.next;
        if (first == last) {
            last = null;
            return;
        }
        while (first.next != last) {
            first = first.next;
        }
        first.next = last.next;
        last = first;
    }

    public void removeFirstNodeCLL() {
        if (last == null)
            throw new NoSuchElementException("Empty Nodes");
        ListNode first = last.next;
        if (first == last) {
            last = null;
        } else
            last.next = first.next;
        first.next = null;
    }

    public void insertNodeAtEndCircularLL(int value) {
        ListNode temp = new ListNode(value);
        if (last == null) {
            last = temp;
            last.next = temp;
        } else {
            temp.next = last.next;
            last.next = temp;
            last = temp;
        }
    }

    public void insertNodeAtBeginning(int value) {
        ListNode temp = new ListNode(value);
        if (last == null)
            last = temp;
        else
            temp.next = last.next;

        last.next = temp;
    }
}
