package datastructuresandalgorithms.practiceproblems;

import datastructuresandalgorithms.singlylinkedlist.SinglyLinkedList;

import java.util.NoSuchElementException;
import java.util.Stack;

public class SinglyLinkedLists {
    private ListNode head;

    private static class ListNode {
        private int data;
        private ListNode next;

        ListNode(int data) {
            this.data = data;
        }
    }

    public ListNode firstLinkedList() {
        ListNode first = new ListNode(2);
        ListNode second = new ListNode(4);
        ListNode third = new ListNode(7);
        head = first;
        first.next = second;
        second.next = third;
        third.next = null;
        return head;
    }

    public ListNode secondLinkedList() {
        ListNode first = new ListNode(0);
        ListNode second = new ListNode(5);
        ListNode third = new ListNode(6);
        head = first;
        first.next = second;
        second.next = third;
        third.next = null;
        return head;
    }


    public static void main(String[] args) {
        SinglyLinkedLists singlyLinkedList = new SinglyLinkedLists();
        //1,2,3,3,4,4,5
        ListNode first = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);
        ListNode fourth = new ListNode(4);
        ListNode fifth = new ListNode(5);
        /*ListNode sixth = new ListNode(40);
        ListNode seventh = new ListNode(50);*/
        // ListNode eight = new ListNode(50);
        singlyLinkedList.head = first;
        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        /*fifth.next = sixth;
        sixth.next = seventh;
        seventh.next = null;*/
        //eight.next=null;
        singlyLinkedList.display();

        // singlyLinkedList.deleteNodeProvidedNode(seventh);

        singlyLinkedList.reverseBetween(singlyLinkedList.head, 2, 4);
        //singlyLinkedList.display();


        //  singlyLinkedList.removeDuplicatesFromSortedListII1();
        //singlyLinkedList.removeNodeBasedOnkey1(20);

        // singlyLinkedList.removeDuplicatesFromSortedList();
        //singlyLinkedList.display();
        // singlyLinkedList.addNewNodeInSortedOrder(5);
        //singlyLinkedList.removeNodeBasedOnKey(10);
        // //  System.out.println(singlyLinkedList.startOfCyle().data);
       /* System.out.println(singlyLinkedList.isPalindromeUsingStack());
        singlyLinkedList.reverseBetween(2, 6);
        singlyLinkedList.display();*/


        /*ListNode current = singlyLinkedList.firstLinkedList();
        singlyLinkedList.display();
        ListNode temp = singlyLinkedList.secondLinkedList();
        singlyLinkedList.display();
        singlyLinkedList.substractTwoNumberSLL(current, temp);
        // singlyLinkedList.mergeTwoLinkedList(current, temp);
        singlyLinkedList.display();*/

        //  singlyLinkedList.display();
        /*singlyLinkedList.head = singlyLinkedList.reverseSinglyLinkedList(singlyLinkedList.head);
        singlyLinkedList.display();*/
        // System.out.println(singlyLinkedList.middleNode(singlyLinkedList.head).data);
        /*singlyLinkedList.head=*/
        // singlyLinkedList.head = singlyLinkedList.removeNthNode(singlyLinkedList.head, 5);
        //  singlyLinkedList.head = singlyLinkedList.removeNthNodeFromEnd(singlyLinkedList.head, 1);
        //singlyLinkedList.display();
    }

    public ListNode reverseSinglyLinkedList(ListNode head) {
        ListNode current = head;
        ListNode previous = null;
        while (current != null) {
            ListNode temp = current.next;
            current.next = previous;
            previous = current;
            current = temp;
        }
        return previous;
    }

    public ListNode middleNode(ListNode head) {
        ListNode current = head;
        ListNode slowPtr = current;
        ListNode fastPtr = current;
        while (fastPtr != null && fastPtr.next != null) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }
        return slowPtr;
    }

    public ListNode removeNthNode(ListNode head, int n) {
        if (n <= 0) {
            return head;
        }
        ListNode myFinal = head;
        ListNode temp = head;
        int count = 0;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        ListNode current = head;
        ListNode previous = null;
        if (count == n) {
            return head.next;
        }
        while (count > n) {
            count--;
            previous = current;
            current = current.next;
        }
        previous.next = current.next;
        return myFinal;
    }

    public ListNode removeNthNodeFromEnd(ListNode head, int n) {
        ListNode refPtr = head;
        ListNode mainPtr = head;
        ListNode previous = null;
        int count = 1;
        while (count < n) {
            count++;
            refPtr = refPtr.next;
        }
        if (refPtr.next == null) {
            return head.next;
        }
        while (refPtr.next != null) {
            previous = mainPtr;
            mainPtr = mainPtr.next;
            refPtr = refPtr.next;
        }
        previous.next = mainPtr.next;
        return head;
    }

    public ListNode removeDuplicatesFromSortedList() {
        ListNode current = head;
        while (current != null && current.next != null) {
            if (current.data == current.next.data)
                current.next = current.next.next;
            else current = current.next;
        }
        return head;
    }

    public ListNode removeDuplicatesFromSortedListII1() {
        if (head == null)
            return null;
        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;
        int count = 1;
        ListNode current = head;
        while (current != null && current.next != null) {
            if (current.data == current.next.data) {
                count++;
                current = current.next;
            } else {
                if (count == 1) {
                    ListNode nextNode = current.next;
                    current.next = null;
                    temp.next = current;
                    temp = current;
                    current = nextNode;
                } else {
                    current = current.next;
                    count = 1;
                }
            }
        }
        if (count == 1 && current.next == null) {
            temp.next = current;
        }
        return dummy.next;
    }


    public ListNode addTwoNumberSLL(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;
        int carry = 0;
        while (list1 != null || list2 != null) {
            int x = (list1 != null) ? list1.data : 0;
            int y = (list2 != null) ? list2.data : 0;
            int sum = x + y + carry;
            carry = sum / 10;
            temp.next = new ListNode(sum % 10);
            temp = temp.next;
            if (list1 != null)
                list1 = list1.next;
            if (list2 != null)
                list2 = list2.next;
        }
        if (carry > 0)
            temp.next = new ListNode(carry);
        return head = dummy.next;
    }

    public ListNode substractTwoNumberSLL(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;
        int borrow = 0;
        while (list1 != null || list2 != null) {
            int x = (list1 != null) ? list1.data : 0;
            int y = (list2 != null) ? list2.data : 0;
            x = x - borrow;
            if (x < y) {
                x = x + 10;
                borrow = 1;
            }
            temp.next = new ListNode(x - y);
            temp = temp.next;
            if (list1 != null)
                list1 = list1.next;
            if (list2 != null)
                list2 = list2.next;
        }
        return head = dummy.next;
    }

    public void removeDuplicatesFromSortedListII() {
        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;
        int count = 1;
        ListNode current = head;
        while (current != null && current.next != null) {
            if (current.data == current.next.data) {
                count++;
                current.next = current.next.next;
            } else {
                if (count == 1) {
                    ListNode nextNode = current.next;
                    temp.next = current;
                    temp = current;
                    current = nextNode;
                    count = 1;
                } else {
                    current = current.next;
                    count = 1;
                }
            }
        }
        if ((count == 1) && (current == null || current.next == null)) {
            temp.next = current;
        }
        head = dummy.next;
    }

    public ListNode removeNodeBasedOnkey1(int val) {
        while (head != null && head.data == val) {
            head = head.next;
        }
        ListNode current = head;
        while (current != null && current.next != null) {
            if (current.next.data == val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return head;
    }

    public ListNode addNewNodeInSortedOrder(int data) {
        ListNode newNode = new ListNode(data);
        ListNode current = head;
        ListNode previous = null;
        if (newNode.data < head.data) {
            newNode.next = head;
            head = newNode;
            return head;
        }
        while (current != null && newNode.data > current.data) {
            previous = current;
            current = current.next;
        }
        previous.next = newNode;
        newNode.next = current;
        return head;
    }


    public ListNode deleteNode(int position) {
        if (head == null)
            throw new NoSuchElementException();
        ListNode current = head;
        ListNode previous = null;
        if (position == 1) {
            head = head.next;
            return current;
        }
        int count = 1;
        while (count < position) {
            count++;
            previous = current;
            current = current.next;
        }
        previous.next = current.next;
        return current;
    }

    public void deleteNodeProvidedNode(ListNode node) {
        node.data = node.next.data;
        node.next = node.next.next;
    }

    public ListNode deleteGreaterNodethanEveryNode() {
        ListNode current = head;
        ListNode previous = null;
        while (current != null) {
            ListNode second = current.next;
            while (second != null) {
                if (second.data > current.data) {
                    if (current == head) {
                        head = head.next;
                    } else {
                        previous.next = second;
                    }
                    break;
                } else {
                    second = second.next;
                }
            }
            previous = head;
            current = current.next;
        }
        return head;
    }

    public ListNode removeNodeBasedOnKey(int val) {
       /* ListNode current = head;
        ListNode previous = null;
        while (current != null) {
            ListNode temp = current.next;
            if (head.data == val) {
                head = head.next;
                current = head;
            } else if (current.data == val) {
                previous.next = temp;
                current = temp;
            } else {
                previous = current;
                current = current.next;
            }
        }
        return head;*/
        while (head != null && head.data == val)
            head = head.next;
        ListNode current = head;
        while (current != null && current.next != null) {
            if (current.next.data == val)
                current.next = current.next.next;
            else
                current = current.next;
        }
        return head;
    }

    public boolean hasCycle() {
        ListNode slowPtr = head;
        ListNode fastPtr = head;
        while (fastPtr != null && fastPtr.next != null) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
            if (slowPtr == fastPtr)
                return true;
        }
        return false;
    }

    public ListNode startOfCyle() {
        ListNode slowPtr = head;
        ListNode fastPtr = head;
        ListNode temp = head;
        while (fastPtr != null && fastPtr.next != null) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
            if (slowPtr == fastPtr) {
                if (slowPtr == temp)
                    return temp;
                while (slowPtr != temp) {
                    temp = temp.next;
                    slowPtr = slowPtr.next;
                }
                return temp;
            }
        }
        return null;
    }

    public ListNode startNode(ListNode slowPtr) {
        ListNode temp = head;
        while (slowPtr != temp) {
            temp = temp.next;
            slowPtr = slowPtr.next;
        }
        return temp;
    }

    public boolean linkedListIsPalindrome() {
        ListNode current = head;
        int count = 0;
        while (current != null) {
            count++;
            current = current.next;
        }
        current = head;
        int[] array = new int[count];
        int i = 0;
        while (current != null) {
            array[i] = current.data;
            current = current.next;
            i++;
        }
        i = 0;
        ListNode previous = reverseSinglyLinkedList(head);
        while (previous != null) {
            if (previous.data == array[i]) {
                i++;
                previous = previous.next;
            } else {
                return false;
            }
        }
        return true;
    }

    public boolean linkedListIsPalindrome1() {
        ListNode head2 = null;
        ListNode current = head;
        ListNode current2 = head2;
        while (current != null) {
            if (head2 == null) {
                head2 = new ListNode(current.data);
                current2 = head2;
            } else {
                ListNode temp = new ListNode(current.data);
                current2.next = temp;
                current2 = temp;
            }
            current = current.next;
        }
        head = reverseSinglyLinkedList(head);
        current = head;
        current2 = head2;
        while (current != null) {
            if (current.data != current2.data)
                return false;
            current = current.next;
            current2 = current2.next;
        }
        return true;
    }

    public boolean isPalindromeUsingStack() {
        ListNode current = head;
        Stack<Integer> stack = new Stack();
        while (current != null) {
            stack.push(current.data);
            current = current.next;
        }
        current = head;
        while (current != null) {
            if (current.data != stack.peek())
                return false;
            stack.pop();
            current = current.next;
        }
        return true;
    }

    public ListNode reverseBetween(int left, int right) {
        int count = 1, orgLeft = left, orgRight = right;
        ListNode leftPtr = head;
        ListNode rightPtr = head;
        ListNode beforeLeft = null;
        ListNode afterRight = null;
        if (count == left) {
            leftPtr = head;
        } else {
            while (count < left) {
                count++;
                beforeLeft = leftPtr;
                leftPtr = leftPtr.next;
            }
            rightPtr = leftPtr;
        }
        while (left < right) {
            left++;
            rightPtr = rightPtr.next;
        }
        if (rightPtr.next != null) {
            afterRight = rightPtr.next;
        }
        if (beforeLeft != null) {
            beforeLeft.next = previousSubset(leftPtr, orgLeft, orgRight);
            leftPtr.next = afterRight;
        } else {
            head = previousSubset(leftPtr, orgLeft, orgRight);
            leftPtr.next = afterRight;
        }
        return head;
    }

    public ListNode previousSubset(ListNode leftPointer, int left, int right) {
        ListNode previous = null;
        while (left <= right) {
            left++;
            ListNode temp = leftPointer.next;
            leftPointer.next = previous;
            previous = leftPointer;
            leftPointer = temp;
        }
        return previous;
    }


    public ListNode mergeTwoLinkedList(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        while (list1 != null && list2 != null) {
            if (list1.data < list2.data) {
                current.next = list1;
                current = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                current = list2;
                list2 = list2.next;
            }
        }
        if (list2 == null) {
            current.next = list1;
        }
        if (list1 == null) {
            current.next = list2;
        }
        return dummy.next;
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null) return null;
        ListNode current = head;
        ListNode prev = null;
        ListNode headStart = null;
        ListNode tail = null;
        int counter = 0;
        while (counter <= right) {
            counter++;
            if (counter == left) {
                headStart = current;
                tail = current;
                current = current.next;
            } else if (counter > left) {
                ListNode next = current.next;
                current.next = headStart;
                headStart = current;
                current = next;
            } else {
                prev = current;
                current = current.next;
            }
        }
        if (prev != null) {
            prev.next = headStart;
            tail.next = current;
            return head;
        } else {
            headStart.next = current;
            return headStart;
        }
    }


    public void display() {
        if (head == null)
            return;
        ListNode current = head;
        while (current != null) {
            System.out.print(current.data + " -->");
            current = current.next;
        }
        System.out.print(" null");
        System.out.println();
    }
}
