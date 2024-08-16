package org.example;

public class SinglyLinkedList {
    private ListNode head;

    private static class ListNode {
        private int data;
        private ListNode next;

        ListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public void display() {
        ListNode current = head;
        int count = 0;
        while (current != null) {
            System.out.print(current.data + " -->");
            count++;
            current = current.next;
        }
        System.out.print("null");
        System.out.println();
        System.out.println("The number of nodes in single linked list are " + count);
    }

    public int lengthSinglyLinkedList() {
        ListNode current = head;
        int count = 0;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    public void addNewNodeAtBeginning(int value) {
        ListNode newNode = new ListNode(value);
        newNode.next = head;
        head = newNode;
    }

    public void addNewNodeAtEnd(int value) {
        ListNode current = head;
        if (head == null) {
            head = new ListNode(value);
            return;
        }
        ListNode endNode = new ListNode(value);
        while (current != null) {
            if (current.next == null) {
                current.next = endNode;
                current = current.next;
                break;
            }
            current = current.next;
        }
    }

    public void addNewNodeAtEndSecondApproach(int value) {
        ListNode newNode = new ListNode(value);
        if (head == null) {
            head = newNode;
            return;
        }
        ListNode current = head;
        while (current.next != null) current = current.next;
        current.next = newNode;
    }

    public void addNodeAtGivenPosition(int position, int value) {
        int count = 0;
        ListNode newNode = new ListNode(value);
        if (head == null) {
            head = newNode;
            return;
        }
        ListNode current1 = head;
        ListNode current2 = head;
        while (current1 != null || current2 != null) {
            count++;
            if (count == position) {
                newNode.next = head;
                head = newNode;
                current1 = head;
                current2 = head;
            }
            if (count + 1 == position) {
                if (current2.next != null || current1.next != null) {
                    current2 = current2.next;
                    current1.next = newNode;
                    current1 = current1.next;
                    newNode.next = current2;
                    return;
                } else {
                    current1.next = newNode;
                    current2.next = newNode;
                    return;
                }
            }
            current1 = current1.next;
            current2 = current2.next;
        }
    }

    public void addNodeAtGivenPositionSecondApproach(int position, int value) {
        ListNode newNode = new ListNode(value);
        if (position < 1 || (position > lengthSinglyLinkedList() + 1))
            throw new IllegalArgumentException("Position is not within the range of singly linked list");
        if (position == 1) {
            newNode.next = head;
            head = newNode;
        } else {
            ListNode previous = head;
            int count = 1;
            while (count < position - 1) {
                previous = previous.next;
                count++;
            }
            ListNode current = previous.next;
            newNode.next = current;
            previous.next = newNode;
        }
    }

    public void deleteFirstNode() {
        ListNode current = head;
        if (head != null) {
            current = current.next;
            head = current;
        }
    }

    public ListNode deleteFirstNodeAndReturn() {
        if (head == null) return null;
        ListNode temp = head;
        head = head.next;
        temp.next = null;
        return temp;
    }

    public void deleteLastNode() {
        ListNode current = head;
        int count = 1;
        if (head != null) {
            while (count < lengthSinglyLinkedList() - 1) {
                current = current.next;
                count++;
            }
            current.next = null;
        }
    }

    public ListNode deleteLastNodeAndReturn() {
        if (head == null || head.next == null) return head;
        //If there is only one NODE and if you dont want to delete it then above solution helps, still if wants to delete
        //then use
        // if(head == null) return null;
        ListNode previous = head;
        int count = 1;
        while (count < lengthSinglyLinkedList() - 1) {
            previous = previous.next;
            count++;
        }
        ListNode temp = previous.next;
        previous.next = null;
        return temp;
    }

    public ListNode deleteLastNodeWithoutLength() {
        if (head == null || head.next == null) return head;
        ListNode current = head;
        ListNode previous = null;
        while (current.next != null) {
            previous = current;
            current = current.next;
        }
        previous.next = null;
        return current;
    }


    public ListNode deleteNodeAtPositionWithoutLength(int position) {
        if (position == 1) {
            if (head == null || head.next == null) return head;
            ListNode temp = head;
            head = head.next;
            temp.next = null;
            return temp;
        }
        if (position > lengthSinglyLinkedList()) position = lengthSinglyLinkedList();
        int count = 1;
        ListNode current = head;
        ListNode previous = null;
        while (count <= position - 1) {
            previous = current;
            current = current.next;
            count++;
        }
        ListNode temp = current;
        current = current.next;
        previous.next = current;
        temp.next = null;
        return temp;
    }


    public void deleteNodeAtPosition(int position) {
        ListNode previous = head;
        if (position == 1) head = head.next;
        else {
            int count = 1;
            while (count < position - 1) {
                previous = previous.next;
                count++;
            }
            ListNode current = previous.next;
            current = current.next;
            previous.next = current;
        }
    }

    public boolean nodeIsPresent(int searchKey) {
        ListNode current = head;
        if (head == null) return false;
        while (current != null) {
            if (current.data == searchKey) return true;
            current = current.next;
        }
        return false;
    }

    public static void main(String[] args) {
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
       /* singlyLinkedList.head = new ListNode(10);
        ListNode second = new ListNode(20);
        ListNode third = new ListNode(30);
        ListNode fourth = new ListNode(40);
        singlyLinkedList.head.next = second;
        second.next = third;
        third.next = fourth;
        singlyLinkedList.display();*/
        //Here we have inserted the new node at the beginning of singly linked list.
        // singlyLinkedList.addNewNodeAtBeginning(50);
        //singlyLinkedList.addNewNodeAtBeginning(60);
        // singlyLinkedList.addNewNodeAtEnd(70);
        /*singlyLinkedList.addNewNodeAtBeginning(80);
        singlyLinkedList.addNewNodeAtEndSecondApproach(35);
        singlyLinkedList.addNewNodeAtEndSecondApproach(45);
        singlyLinkedList.addNodeAtGivenPosition(1, 40);
        singlyLinkedList.addNodeAtGivenPositionSecondApproach(4, 40);
        singlyLinkedList.display();*/
        //singlyLinkedList.deleteFirstNode();
        //singlyLinkedList.deleteLastNode();
        //singlyLinkedList.deleteNodeAtPosition(3);
        //singlyLinkedList.deleteLastNode();
        //singlyLinkedList.deleteFirstNodeAndReturn();
        singlyLinkedList.addNodeAtGivenPosition(1, 2);
        singlyLinkedList.addNodeAtGivenPosition(2, 3);
        singlyLinkedList.addNodeAtGivenPosition(3, 2);
        singlyLinkedList.addNodeAtGivenPosition(4, 2);
        singlyLinkedList.addNodeAtGivenPosition(5, 3);
        singlyLinkedList.addNodeAtGivenPosition(6, 4);
        singlyLinkedList.addNodeAtGivenPosition(7, 5);
        singlyLinkedList.addNodeAtGivenPosition(8, 4);
        singlyLinkedList.addNodeAtGivenPosition(9, 2);
        singlyLinkedList.display();
        singlyLinkedList.removeDuplicates();


        //   System.out.println(singlyLinkedList.isPalindrome());
        singlyLinkedList.display();
        /*  singlyLinkedList.reverseMySLL();*/
        // singlyLinkedList.display();
        // singlyLinkedList.display();
        /*singlyLinkedList.addNodeSortedLinkedList(65);
        singlyLinkedList.addNodeSortedLinkedList(75);*/
        /*singlyLinkedList.createLinkedListHavingLoop();
        System.out.println(singlyLinkedList.startOfLoop().data);
        singlyLinkedList.removeLoopSinglyLinkedList();
        singlyLinkedList.display();*/


       /* ListNode current = singlyLinkedList.firstLinkedList();
        singlyLinkedList.display();
        ListNode temp = singlyLinkedList.secondLinkedList();
        singlyLinkedList.display();
        singlyLinkedList.subtractTwoNumbers(current, temp);*/
        /*  singlyLinkedList.sortingSLL(current, temp);*/
        // singlyLinkedList.additionTwoNumbers(current, temp);
        //singlyLinkedList.addTwoSum(current, temp);
        //singlyLinkedList.mergeTwoLinkedList(current, temp);
        //singlyLinkedList.mergeTwoLinkedListInSortedOrderFinalApproach(current, temp);
        // singlyLinkedList.mergeTwoLinkedListInSortedOrder(current, temp);

        // singlyLinkedList.removeDuplicatesSLL();
        //     singlyLinkedList.display();
        //singlyLinkedList.removeNodeBasedOnKey(60);
        //singlyLinkedList.findDuplicateNodeAndRemove();
        // System.out.println(singlyLinkedList.findNNodeFromEndSecondApproach(5).data);

        //System.out.println(singlyLinkedList.findNNodeFromEnd(6).data);

        //System.out.println(singlyLinkedList.isPresent(60));
        //singlyLinkedList.addNodeAtGivenPosition(3, 60);
        //singlyLinkedList.deleteLastNodeAndReturn();
        // System.out.println(singlyLinkedList.deleteLastNodeWithoutLength().data);
        //System.out.println(singlyLinkedList.deleteNodeAtPositionWithoutLength(5).data);
        //   singlyLinkedList.deleteNodeAtPosition(1);
        // singlyLinkedList.display();
        //System.out.println(singlyLinkedList.middleNodeSecondApproach().data);
     /*   singlyLinkedList.reverseSinglyLinkedList();
        singlyLinkedList.display();*/
        /*singlyLinkedList.reverseLinkedList();
        singlyLinkedList.display();*/
        //  System.out.println(singlyLinkedList.nodeIsPresent(30));
        // 10 ---> 20 ---> 30 --> null
    }


    public boolean isPresent(int searchKey) {
        if (head == null) return false;
        ListNode current = head;
        while (current != null) {
            if (current.data == searchKey) return true;
            current = current.next;
        }
        return false;
    }

    public ListNode reverseSinglyLinkedList() {
        if (head == null) {
            return head;
        }
        ListNode current = head;
        ListNode previous = null;
        ListNode next = null;
        while (current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        return head = previous;
    }

    public ListNode middleNode() {
        ListNode current = head;
        int count = 0;
        while (current != null) {
            count++;
            current = current.next;
        }
        int thirdNode = count / 2 + 1;
        ListNode temp = head;
        int tempCount = 0;
        while (temp != null) {
            tempCount++;
            if (tempCount == thirdNode) break;
            temp = temp.next;
        }
        return temp;
    }

    public ListNode middleNodeSecondApproach() {
        ListNode slowPtr = head;
        ListNode fastPtr = head;
        while (fastPtr != null && fastPtr.next != null) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }
        return slowPtr;
    }

    public ListNode findNNodeFromEnd(int nthNode) {
        if (head == null) {
            return head;
        }
        if (nthNode <= 0) throw new IllegalArgumentException("Invalid Value " + nthNode);
        ListNode refPointer = head;
        ListNode mainPointer = head;
        int count = 0;
        //if someone provides the n value greater than alength of linked list then it refpointer will move to null
        while (count < nthNode) {
            if (refPointer == null) throw new IllegalArgumentException(nthNode + " is greater than length of SLL");
            refPointer = refPointer.next;
            count++;
        }
        while (refPointer != null) {
            refPointer = refPointer.next;
            mainPointer = mainPointer.next;
        }
        return mainPointer;
    }

    public ListNode findNNodeFromEndSecondApproach(int nthNode) {
        if (head == null) {
            return head;
        }
        ListNode current = head;
        ListNode temp = head;
        int count = 1;
        while (current != null) {
            current = current.next;
            count++;
        }
        int fcount = 0;
        while (fcount < (count - (nthNode + 1))) {
            temp = temp.next;
            fcount++;
        }
        return temp;
    }

    public void findDuplicateNodeAndRemove() {
        ListNode current = head;
        if (head == null) return;
        while (current != null && current.next != null) {
            if (current.data == current.next.data) current.next = current.next.next;
            else current = current.next;
        }

    }

    //10 20 -- 25(newNode)--30 40

    public ListNode addNodeSortedLinkedList(int value) {
        ListNode newNode = new ListNode(value);
        if (head == null) return newNode;
        ListNode current = head;
        ListNode previous = null;
        if (value < head.data) {
            newNode.next = head;
            head = newNode;
            return head;
        }
        while (current != null && current.data < newNode.data) {
            previous = current;
            current = current.next;
        }
        newNode.next = current;
        previous.next = newNode;
        return head;
    }

    public ListNode removeNodeBasedOnKey(int key) {
        if (head == null) return head;
        ListNode current = head;
        if (head.data == key) {
            head = current.next;
            return head;
        }
        ListNode previous = null;
        while (current != null && current.data != key) {
            previous = current;
            current = current.next;
        }
        if (current == null) return previous;
        previous.next = current.next;
        return current;
    }

    public boolean linkedListHasLoop() {
        ListNode slowPtr = head;
        ListNode fastPtr = head;
        while (fastPtr != null && fastPtr.next != null) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
            if (slowPtr == fastPtr) return true;
        }
        return false;
    }

    public void createLinkedListHavingLoop() {
        ListNode first = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);
        ListNode fourth = new ListNode(4);
        ListNode fifth = new ListNode(5);
        ListNode sixth = new ListNode(6);
        head = first;
        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = sixth;
        sixth.next = third;
    }

    public ListNode startOfLoop() {
        ListNode slowPtr = head;
        ListNode fastPtr = head;
        while (fastPtr != null && fastPtr.next != null) {
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;
            if (slowPtr == fastPtr) return getStartedNode(slowPtr);
        }
        return null;
    }

    public ListNode getStartedNode(ListNode slowPtr) {
        ListNode temp = head;
        while (slowPtr != temp) {
            temp = temp.next;
            slowPtr = slowPtr.next;
        }
        return temp;
    }

    public ListNode removeStartedNode(ListNode slowPtr) {
        ListNode temp = head;
        ListNode previous = null;
        while (slowPtr != temp) {
            temp = temp.next;
            previous = slowPtr;
            slowPtr = slowPtr.next;
        }
        return previous;
    }

    public void removeStartNodeApproach1(ListNode slowPtr) {
        ListNode temp = head;
        while (slowPtr.next != temp.next) {
            temp = temp.next;
            slowPtr = slowPtr.next;
        }
        slowPtr.next = null;
    }


    public void removeLoopSinglyLinkedList() {
        ListNode slowPtr = head;
        ListNode fastPtr = head;
        //  ListNode previous=null;
        while (fastPtr != null && fastPtr.next != null) {
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;
            if (slowPtr == fastPtr) {
                removeStartNodeApproach1(slowPtr);
              /*  previous=removeStartedNode(slowPtr);
                previous.next=null;*/
            }
        }
        // return previous;
    }

    public ListNode firstLinkedList() {
        ListNode first = new ListNode(7);
        ListNode second = new ListNode(4);
        ListNode third = new ListNode(2);
        head = first;
        first.next = second;
        second.next = third;
        third.next = null;
        return head;
    }

    public ListNode secondLinkedList() {
        ListNode first = new ListNode(5);
        ListNode second = new ListNode(6);
        ListNode third = new ListNode(0);
        head = first;
        first.next = second;
        second.next = third;
        third.next = null;
        return head;
    }

    public void mergeTwoLinkedList(ListNode list1, ListNode list2) {
        head = list1;
        while (list1 != null && list2 != null) {
            ListNode next = list1.next;
            ListNode tempNext = list2.next;
            list2.next = next;
            list1.next = list2;
            list1 = next;
            list2 = tempNext;
        }
    }

    public void mergeTwoLinkedListInSortedOrder(ListNode current, ListNode temp) {
        if (current.data < temp.data) {
            head = current;
            current = current.next;
        } else {
            head = temp;
            temp = temp.next;
        }
        ListNode tail = head;
        while (current != null && temp != null) {
            if (current.data < temp.data) {
                tail.next = current;
                current = current.next;
            } else {
                tail.next = temp;
                temp = temp.next;
            }
            tail = tail.next;
            if (current == null) tail.next = temp;
            else tail.next = current;
        }

    }

    public void addTwoNumber(ListNode list1, ListNode list2) {
        int count = 0;
        ListNode current1 = list1;
        ListNode current2 = list2;
        while (list1 != null && list2 != null) {
            count++;
            list1 = list1.next;
            list2 = list2.next;
        }
        int[] a = new int[count];
        int[] b = new int[count];
        int c = 0;
        while (current1 != null && current2 != null) {
            a[c] = current1.data;
            b[c] = current2.data;
            c++;
            current1 = current1.next;
            current2 = current2.next;
        }
        a = reverseArray(a, 0, a.length - 1);
        b = reverseArray(b, 0, b.length - 1);
        String s1 = "";
        String s2 = "";
        for (int i = 0; i < a.length; i++)
            s1 = s1 + a[i];
        for (int i = 0; i < a.length; i++)
            s2 = s2 + b[i];
        Integer i1 = Integer.parseInt(s1);
        Integer i2 = Integer.parseInt(s2);
        Integer i3 = i1 + i2;
        String finalString = i3.toString();
        char[] ch = finalString.toCharArray();
        int a1 = Integer.parseInt(Character.valueOf(ch[0]).toString());
        int a2 = Integer.parseInt(Character.valueOf(ch[1]).toString());
        int a3 = Integer.parseInt(Character.valueOf(ch[2]).toString());
        ListNode node1 = new ListNode(a1);
        ListNode node2 = new ListNode(a2);
        ListNode node3 = new ListNode(a3);
        head = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = null;
    }

    private int[] reverseArray(int[] array, int start, int end) {
        while (start < end) {
            int temp = array[end];
            array[end] = array[start];
            array[start] = temp;
            start++;
            end--;
        }
        return array;
    }

    public void addTwoSum(ListNode a, ListNode b) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        int carry = 0;
        while (a != null || b != null) {
            int x = (a != null) ? a.data : 0;
            int y = (b != null) ? b.data : 0;
            int sum = x + y + carry;
            carry = sum / 10;
            tail.next = new ListNode(sum % 10);
            tail = tail.next;
            if (a != null) a = a.next;
            if (b != null) b = b.next;
        }
        if (carry > 0) tail.next = new ListNode(carry);

        head = dummy.next;
    }

    public void mergeTwoLinkedListInSortedOrderFinalApproach(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        if (list1.data < list2.data) {
            head = list1;
            list1 = list1.next;
        } else {
            head = list2;
            list2 = list2.next;
        }
        //ListNode tail = dummy;
        ListNode tail = head;
        while (list1 != null && list2 != null) {
            if (list1.data < list2.data) {
                tail.next = list1;
                list1 = list1.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
            }
            tail = tail.next;
            if (list1 == null) tail.next = list2;
            else tail.next = list1;
        }
        //head=dummy.next;
    }


    public void sortingSLL(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while (list1 != null && list2 != null) {
            if (list1.data < list2.data) {
                tail.next = list1;
                list1 = list1.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
            }
            tail = tail.next;
            if (list1 == null) {
                tail.next = list2;
            }
            if (list2 == null) {
                tail.next = list1;
            }
        }
        head = dummy.next;
    }

    public void additionTwoNumbers(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        int carry = 0;
        while (list1 != null || list2 != null) {
            int x = (list1 != null) ? list1.data : 0;
            int y = (list2 != null) ? list2.data : 0;
            int sum = x + y + carry;
            carry = sum / 10;
            tail.next = new ListNode(sum % 10);
            tail = tail.next;
            if (list1 != null)
                list1 = list1.next;
            if (list2 != null)
                list2 = list2.next;

        }
        if (carry > 0) {
            tail.next = new ListNode(carry);

        }
        head = dummy.next;
    }

    public void removeDuplicatesSLL() {
        ListNode current = head;
        while (current != null) {
            if (current.data == current.next.data)
                current.next = current.next.next;
            else {
                current = current.next;
            }
            current = current.next.next;
        }
    }

    public void subtractTwoNumbers(ListNode a, ListNode b) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        int borrow = 0;
        while (a != null || b != null) {
            int x = (a != null) ? a.data : 0;
            int y = (b != null) ? b.data : 0;
            int z = x - y;
            if (z < 0) {
                z = 10 + x - y - borrow;
                borrow = 1;
                tail.next = new ListNode(z);
            } else {
                z = x - y - borrow;
                tail.next = new ListNode(z);
            }
            tail = tail.next;
            if (a != null)
                a = a.next;
            if (b != null)
                b = b.next;
        }
        head = dummy.next;
    }


    public ListNode reverseMySLL() {
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

    public boolean isPalindrome() {
        ListNode orig = head;
        ListNode reverse = reverseMySLL();
        while (orig != null && reverse != null) {
            if (orig.data != reverse.data)
                return false;
            orig = orig.next;
            reverse = reverse.next;
        }
        return true;
    }

    public void sorting() {
        ListNode dummy1 = new ListNode(0);
        ListNode tail1 = dummy1;
        ListNode a = head;
        ListNode b = head.next;
        while (a != null && b != null) {
            if (a.data > b.data) {
                ListNode temp = a;
                a.next = tail1;
                a = b;
                b = b.next;
                tail1 = temp;
            }
        }
        if (b == null) {
            a.next = tail1;
            tail1 = a;
        }
        head = tail1;
    }

    public void removeDuplicates() {
        ListNode first = head;
        ListNode previous = first;
        while (first != null && first.next != null) {
            ListNode second = first.next;
            while (second != null) {
                ListNode temp = second.next;
                if (first.data == second.data) {
                    previous.next = second.next;
                    second = temp;
                } else {
                    previous = second;
                    second = temp;
                }
            }
            first = first.next;
            previous = first;
        }
    }
}
