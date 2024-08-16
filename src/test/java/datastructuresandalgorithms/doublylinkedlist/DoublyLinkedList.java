package datastructuresandalgorithms.doublylinkedlist;

import java.util.NoSuchElementException;

public class DoublyLinkedList {
    private ListNode head;
    private ListNode tail;

    private static class ListNode {
        int data;
        ListNode previous;
        ListNode next;

        ListNode(int data) {
            this.data = data;
        }
    }

    public void displayFromHead() {
        if (head == null)
            return;
        ListNode current = head;
        while (current != null) {
            System.out.print(current.data + " -->");
            current = current.next;
        }
        System.out.println(" null");
        System.out.println();
    }

    public int length() {
        ListNode temp = head;
        int count = 0;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }


    public void displayFromTail() {
        if (tail == null)
            return;
        ListNode temp = tail;
        while (temp != null) {
            System.out.print(temp.data + " -->");
            temp = temp.previous;
        }
        System.out.println(" null");
        System.out.println();
    }

    public static void main(String[] args) {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        /*ListNode first = new ListNode(10);
        ListNode second = new ListNode(20);
        ListNode third = new ListNode(30);
        ListNode fourth = new ListNode(40);
        doublyLinkedList.head = first;
        first.previous = null;
        first.next = second;
        second.previous = first;
        second.next = third;
        third.previous = second;
        third.next = fourth;
        fourth.previous = third;
        fourth.next = null;
        doublyLinkedList.tail = fourth;*/
        //doublyLinkedList.insertStarting(10);
        /*doublyLinkedList.insertStarting(9);
        doublyLinkedList.insertStarting(8);
      */
       /* doublyLinkedList.insertAtEnd(11);
        doublyLinkedList.insertAtEnd(12);
        doublyLinkedList.insertAtEnd(13);*/
        doublyLinkedList.insertLastNode(10);
        doublyLinkedList.insertLastNode(20);
        doublyLinkedList.insertLastNode(30);
        // doublyLinkedList.displayFromHead();
        //doublyLinkedList.deleteVeryFirstNode();
        System.out.println(doublyLinkedList.deleteLastNodeDLL().data);
        doublyLinkedList.displayFromHead();
        doublyLinkedList.displayFromTail();
      /*  doublyLinkedList.insertLastNode(5);
        doublyLinkedList.insertLastNode(4);*/
        //11 - 12 -13 - null
        //   doublyLinkedList.deletefirstNode();

        // doublyLinkedList.removeFirstNode();
        //  doublyLinkedList.removeFirstNode();
        // doublyLinkedList.displayFromHead(); // 11- 12 - null
       /* doublyLinkedList.insertAtEnd(11);
        doublyLinkedList.insertAtEnd(12);
        doublyLinkedList.insertAtEnd(13);*/
        //doublyLinkedList.deleteLastNode();
        //doublyLinkedList.displayFromHead();

        System.out.println("The length of DLL is " + doublyLinkedList.length());
    }


    public void insertAtBeginning(int value) {
        ListNode newNode = new ListNode(value);
        if (head == null) {
            tail = newNode;
        } else {
            head.previous = newNode;
        }
        newNode.next = head;
        head = newNode;
    }

    public void insertStarting(int value) {
        ListNode newNode = new ListNode(value);
        if (head == null) {
            tail = newNode;
        } else {
            head.previous = newNode;
            newNode.next = head;
        }
        head = newNode;
    }

    public void insertAtEnd(int value) {
        ListNode newNode = new ListNode(value);
        if (head == null) {
            head = newNode;
        } else {
            tail.next = newNode;
        }
        newNode.previous = tail;
        tail = newNode;
    }

    public void removeFirstNode() {
        if (head == null)
            return;
        ListNode current = head;
        ListNode temp = head.next;
        current.next = null;
        temp.previous = null;
        head = temp;
    }

    public void removeLastNode() {
        if (tail == null)
            return;
        ListNode temp = tail.previous;
        tail.previous = null;
        temp.next = null;
        tail = temp;
    }

    public boolean isEmpty() {
        return length() == 0;
    }


    public void insertLastNode(int value) {
        ListNode newNode = new ListNode(value);
        if (head == null) {
            head = newNode;
        } else {
            tail.next = newNode;
            newNode.previous = tail;
        }
        tail = newNode;
    }

    public void deletefirstNode() {
        if (head == null)
            return;
        if (head.next == null && head.previous == null) {
            head = null;
            tail = null;
        } else {
            head = head.next;
            head.previous = null;
        }
    }

    public void deleteLastNode() {
        if (head == null)
            return;
        if (head.next == null && head.previous == null) {
            head = null;
            tail = null;
        } else {
            ListNode current = head;
            ListNode previous = null;
            while (current.next != null) {
                previous = current;
                current = current.next;
            }
            current.previous = null;
            tail = previous;
            tail.next = null;
        }
    }

    public void deleteVeryFirstNode() {
        if (head == null)
            return;
        else if (head.next == null && head.previous == null) {
            head = null;
            tail = null;
            return;
        } else {
            ListNode current = head.next;
            head.next = null;
            current.previous = null;
            head = current;
        }
    }

    public void deleteVeryLastNode() {
        if (head == null)
            return;
        else if (head.next == null && head.previous == null) {
            head = null;
            tail = null;
        } else {
            ListNode current = head;
            ListNode previous = null;
            while (current.next != null) {
                previous = current;
                current = current.next;
            }
            previous.next = null;
            current.previous = null;
            tail = previous;
        }
    }

    public ListNode deleteFirstNodeDLL() {
        if (head == null)
            throw new NoSuchElementException();
        ListNode temp = head;
        if (head == tail)
            tail = null;
        else
            head.next.previous = null;
        head = head.next;
        temp.next = null;
        return temp;
    }

    public ListNode deleteLastNodeDLL() {
        if (head == null)
            throw new NoSuchElementException("No Nodes present");
        if (head == tail) {
            head = null;
        } else {
            tail.previous.next = null;
        }
        ListNode temp = tail;
        tail = tail.previous;
        temp.previous = null;
        return temp;
    }
}
