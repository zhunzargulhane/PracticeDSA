package datastructuresandalgorithms.arrays;

//Here we found out the next Greater element using normal technique.
//This can be done using stacks as well.

import java.util.Stack;

public class NextGreaterElement {
    public static void main(String[] args) {
        Stack stack = new Stack();
        int[] array = {4, 7, 3, 4, 8, 1};
        int i = 0, j = 1, k = 0;
        while (i < array.length) {
            while (j < array.length) {
                if (array[j] > array[i]) {
                    array[k] = array[j];
                    k++;
                    break;
                } else {
                    j++;
                }
                if (j == array.length) {
                    array[k] = -1;
                    k++;
                }
            }
            i++;
            j = i + 1;
            if (i == array.length) {
                array[k] = -1;
                k++;
            }
        }
        for (int i1 = 0; i1 < array.length; i1++)
            System.out.print(array[i1] + " ");
    }
}
