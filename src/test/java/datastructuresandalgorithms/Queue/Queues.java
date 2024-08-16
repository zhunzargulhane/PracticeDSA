package datastructuresandalgorithms.Queue;

import java.util.*;
import java.util.stream.Collectors;

public class Queues {

    private ListNode front;
    private ListNode rear;
    private int length;

    private static class ListNode {
        private int data;
        private ListNode next;

        ListNode(int data) {
            this.data = data;
        }
    }

    public void enqueue(int value) {
        ListNode newNode = new ListNode(value);
        if (rear == null)
            front = newNode;
        else
            rear.next = newNode;
        rear = newNode;
        length++;
    }

    public int dequeue() {
        if (front == null)
            throw new RuntimeException("Empty Queue ");
        int result = front.data;
        front = front.next;
        if (front == null)
            rear = null;
        length--;
        return result;
    }

    public int size() {
        return length;
    }

    public void display() {
        if (front == null)
            return;
        ListNode current = front;
        while (current != rear) {
            System.out.print(current.data + " --> ");
            current = current.next;
        }
        System.out.print(current.data + " --> null ");
        System.out.println();
        System.out.println("The size of queue is " + size());
    }

    public int first() {
        if (front == null)
            throw new NoSuchElementException();
        return front.data;
    }

    public int last() {
        if (rear == null)
            throw new NoSuchElementException();
        return rear.data;
    }

    public static void main(String[] args) {
        /*Queues queues = new Queues();
        queues.enqueue(10);
        queues.enqueue(20);
        queues.enqueue(30);
        queues.display();*/
      /*  System.out.println(queues.dequeue());
        System.out.println(queues.dequeue());*/
        //queues.display();
        //System.out.println(queues.first());
       /* System.out.println(queues.last());
        decimalToBinary(5);
        System.out.println();
        System.out.println(binaryToDecimal(1111));*/
        // String[] array = generateBinaryFrom1Ton(5);
        int[][] arr= {{1,2},{3,4}};
        matrixReshape(arr,2,4);
        /*String[] array = generateBinaryUsingQueue(5);
        for (String a : array)
            System.out.println(a);*/
    }

    public static void decimalToBinary(int decimal) {
        int[] array = new int[20];
        int i = 0;
        while (decimal > 0) {
            array[i++] = decimal % 2;
            decimal = decimal / 2;
        }
        for (int k = i; k >= 0; k--)
            System.out.print(array[k] + " ");
    }

    public static int binaryToDecimal(int binary) {
//101
        int pow = 0;
        double sum = 0;
        while (binary > 0) {
            sum = sum + (binary % 10 * Math.pow(2, pow++));
            binary = binary / 10;
        }
        Double d = Double.valueOf(sum);
        return d.intValue();
    }

    public int binaryToDecimal1(int binary){
        int sum =0 ;
        int pow =0 ;
        int number = binary;
        while(number>0){
            int rem = number %10 ;
            sum= (int) (sum+(rem*Math.pow(2,pow++)));
            number=number/10;
        }
        return sum;
    }

    public static int[][] matrixReshape(int[][] mat, int r, int c) {
      int[][] dummy = {{1,2},{3,4}};
      mat=dummy.clone();
      for(int i=0;i<mat.length;i++){
          for(int j=0;j<mat[0].length;j++){
              System.out.print(mat[i][j]);
          }
          System.out.println();
      }
      return null;
    }


    public static String[] generateBinaryFrom1Ton(int n) {
        String total = "";
        for (int i = 1; i <= n; i++) {
            String sum = "";
            int count = 0;
            int result[] = new int[20];
            int reinitialize = i;
            while (i > 0) {
                result[count++] = i % 2;
                i = i / 2;
            }
            for (int k = count - 1; k >= 0; k--) {
                sum = sum + result[k];
            }
            total = total + sum + " ";
            i = reinitialize;
        }
        String[] ss = total.split("\\s");
        return ss;
    }

    public static String[] generateBinaryUsingQueue(int n) {
        String[] array = new String[n];
        Queue<String> queue = new LinkedList();
        queue.offer("1");
        for (int i = 0; i < n; i++) {
            array[i] = queue.poll();
            String n1 = array[i] + "0";
            String n2 = array[i] + "1";
            queue.offer(n1);
            queue.offer(n2);
        }
        return array;
    }
}
